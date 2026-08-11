*Microservices decompose deployment. Java modules decompose code. This piece is about the third decomposition, the one the modeling world keeps not doing: micro-models decompose meaning.*


## The monolith I built

Metamodels rot the same way applications do. They accrete concepts until every consumer pays for every concept, and nobody notices because each addition was individually reasonable.

My [Product Management model](https://product-management.models.nasdanika.org/) got there. It started with a clear job: personas articulate concerns, capabilities are pulled by those concerns, decisions cite the model rather than the loudest voice. But the concepts inside it kept turning out to be bigger than the model that held them. Undergoer, role, and actor are fundamental far beyond product management; I found myself wanting them to track ownership of individual data elements in Ecore annotations. Lifecycle stages wanted to exist without personas anywhere in sight. Capabilities and capability providers wanted to power a bare technology catalog and multi-criteria decision analysis, no product management involved.

When a concept keeps escaping the model you put it in, the model is telling you something. The industry heard the same message from applications and answered with microservices. It heard it from codebases and answered with modules. The answer for metamodels is the same shape: decompose along concern boundaries and make the dependencies explicit.

## What fell out

The refactoring produced a stack, and I have started calling its layers micro-models. A micro-model is a small metamodel with a single concern, explicit dependencies on other micro-models, and no knowledge of its consumers. Concretely:

- **nxcore**: NamedElement, Period, other base classes. The `java.base` of the stack.
- **role**: undergoer / role / actor. Who does what to whom, over a period.
- **lifecycle**: stage definitions with valid transitions, dated stage occurrences on a holder. Built on role, because a thing undergoing a lifecycle is an undergoer.
- **capability**: capabilities, providers, offerings. Built on lifecycle, because providers have lifecycles (GA, deprecated, EOL) and capabilities evolve; Wardley's genesis-to-commodity is just another lifecycle domain.
- **product management**: subclasses capability classes and adds back-references to personas and concerns.

The composition rule matters more than the inventory. Extension happens at the edge, by subclassing in the consuming model. Base models never learn about the models above them. The capability model stays usable for a technology catalog or an MCDA evaluation precisely because it has never heard of a persona.

And because these are Maven/JPMS artifacts, each micro-model is independently versioned, released, and adoptable. You can take nxcore and role and ignore everything else, the same way you take a library and not a framework.

## How big is micro?

Here is where the analogy to code modules earns its keep, and then gets stricter.

The best sizing rule I know for a module is that it shall fit into the team's head. Not into a wiki, not into the head of the one architect who wrote it: into the working memory of the team that owns it. Past that point you are not maintaining a module, you are performing archaeology on one.

For models the rule binds harder, because a model has no information hiding for meaning. A code module hides its implementation behind an interface; consumers never read the internals, so internal complexity is the owner's private problem. A metamodel cannot pull that trick. To query a model, to author against it, to argue from it in a meeting, you must hold its concepts in your head. **The concepts are the interface.** There is nothing behind them to hide.

So the cognitive budget splits into two tests, and a micro-model has to pass both:

**The team test bounds what you own.** The whole micro-model, core concepts plus scaffolding plus the invariants and edge cases, fits into the maintaining team's head. This is the maintenance gate, same as for code.

**The newcomer test bounds what you export.** The core concepts fit into a single diagram on the documentation home page, and a newcomer internalizes that diagram in under fifteen minutes. Not the domains, not the reference plumbing, not the base classes: the handful of concepts that carry the model's one concern. This is the adoption gate, and models face it in a way code does not, because every consumer of a model is a reader of it.

The scaffolding is exempt from the newcomer budget for a structural reason: it is amortized. You learn nxcore once and it is prepaid for every model above it. Explicit dependencies mean each micro-model costs a newcomer only its delta: three or four concepts, one diagram, one cup of coffee. That is the economic argument against the cathedral metamodel in one line. A monolith spends the entire cognitive budget upfront, before the first useful query; a micro-model stack lets adopters pay as they go.

## Prior art, and why the tooling was never the problem

UML's answer to extension was profiles bolted onto a monolith. ArchiMate is a fixed-vocabulary monolith by design: you adopt the whole worldview or none of it, and its famous poster-sized concept map is the anti-pattern of the home-page diagram, the entire budget demanded on day one. EMF/Ecore has supported fine-grained cross-model reuse for two decades, and yet the culture around it still builds cathedrals.

The tooling was never the obstacle. The packaging and dependency discipline was. Maven and JPMS supply exactly that discipline, which is part of why Nasdanika sits on them and not on Eclipse. A model you cannot reuse without adopting someone's entire worldview is a monolith, whatever notation it is drawn in.

## What a model costs, and who pays

Discipline explains why decomposition is possible. It does not explain why cathedrals keep winning by default. Cost does. Every decomposition multiplies fixed overhead: five micro-models means five projects, five documentation sites, five release pipelines. Microservices became viable only when platforms drove the per-service overhead toward zero; before that, the monolith was simply cheaper, and everyone choosing it was right. Micro-models face the same equation.

And the equation has to be solved against the real incumbent. The competitor is not MagicDraw or Sparx; classic modeling tools lost the enterprise long ago. The competitor is Excel, PowerPoint, and Confluence, which won it precisely because their creation cost is effectively zero. A modeling approach that ignores this is arguing with the wrong opponent. So walk the ledger, cost by cost:

- **Creation.** A new multi-module model project is one CLI command: a Maven archetype generates the whole thing. After that, AI populates the Xcore model from a prompt, and it is good at this; the Tibco BW5 and SQL AST metamodels were both seeded that way. That is close enough to the office-tool blank page. The install-license-workspace ritual of a modeling tool never was.

- **Authoring.** Groovy DSL, YAML, JSON, Markdown, Draw.io: whichever surface the author already thinks in. Nobody edits XMI by hand, and nobody installs a specialized editor. A Draw.io diagram is an authoring surface, not a picture of a truth kept somewhere else.

- **Documentation and communication.** Generated out of the box: a home page seeded with the diagram, its elements linked to their documentation, plus context UML diagrams and relationship graphs for every package and class. On GitHub, GitHub Actions publishes it all to GitHub Pages on every push. The 15-minute diagram from the sizing rule is generated, so it cannot drift from the model. Office tools invert this cost: the deck *is* the documentation, it is stale a month later, and nobody can tell which copy is current. And the instances you author get the same treatment as the metamodel: base classes, a starter project, and a polymorphic UI with mix-ins that handles multiple inheritance gracefully, so documentation generation from your models is a solved cost, not a project.

- **Consumption in code.** A Maven dependency, a `requires` line in `module-info.java`, EPackages registered through the capability framework: about five lines of boilerplate. Consuming an Excel "model" means parsing spreadsheets and praying over merged cells. Consuming a PowerPoint model is not a sentence that parses. Consuming from a classic modeling tool means an XMI export and a loader that someone promises to write.

- **Extension and composition.** The same five lines, plus subclassing at the edge. The documentation generator knows the documentation URLs of the dependency models and generates cross-references, so a federated stack of micro-models reads as one site. In office tools, extension is copy-paste, and every copy begins diverging the moment it is made.

- **Execution.** The cost office tools cannot pay at any price, and the reason to have models rather than documents. The capability framework creates services from model elements treated as requirements, recursively: services request other services. This is how archetype project generation works and how the Tibco BW5 execution engine works. The engine is concerned only with service types and with loading a resource; it knows nothing about any particular model. Which means one model, many engines: a model of an agentic system can execute synchronously on the Anthropic Java API for troubleshooting, asynchronously for throughput, on the OpenAI Java API unchanged, on a generator that emits Python for CrewAI, and, of course, on the documentation generator. The model defines the WHAT. Service factories define the HOW, and can do it differently per requirement, with telemetry or without. Engines are exactly that, engines: they carry passengers who comply with the engine's contract. Pay for the ticket, buckle up in the assigned seat.

The pattern in the ledger: match the office tools where they are strong, at creation and authoring, and compound where they are weakest, at consumption, composition, and execution. The one cost no platform can pay for you is the cognitive budget, which is why the sizing rule, not the tooling, decides where model boundaries go.

## Take the microservices lesson seriously

Microservices gave us the distributed monolith, and micro-models have the same failure modes waiting. The sizing rule doubles as the measuring stick for all of them.

The first is leakage: a base model that absorbs its consumers' concerns back in. The moment `role` grows a convenience reference for product management, the decomposition is dead. You can see this one coming on the home page: the diagram starts outgrowing the page, concept by reasonable concept.

The second is version skew across a deep stack. The answer is the boring one from everywhere else: semantic versioning and conservative bases.

The third is over-decomposition, and the newcomer test catches it from the other side. A model with one class and no invariants is not a micro-model; it is a package that lost its way, a diagram that teaches nothing a package name would not. The unit of decomposition is a concern with its own constraints. Lifecycle earns its independence by owning the non-overlap and transition-compliance rules, not by owning a class named Stage.

## The point

Decompose meaning the way you decompose deployment and code: single concern, explicit dependencies, extension at the edge. Then size each piece against heads, not against domains. The whole model fits into the team that owns it. The core concepts fit into one diagram, and that diagram fits into a newcomer in under fifteen minutes.

If it does not, you do not have a big model. You have two models that have not been introduced to each other yet.
