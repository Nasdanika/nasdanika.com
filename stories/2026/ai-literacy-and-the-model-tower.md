*Ninety percent of AI literacy is software engineering. Here is the load-bearing structure.*

<div style="max-width: 720px" class="embed-responsive embed-responsive-16by9">
    <iframe src="https://www.youtube.com/embed/6rEkH8QnDgM?si=3bFbN2I7SVJdF5Jo" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
</div>


A few weeks ago I published [AI Literacy, With Receipts](https://nasdanika.com/stories/2026/ai-literacy.html).
It argued that a glossary is a view, that a view without a source of truth fails the explainability test, and that the vocabulary, governance, and organizational models the argument depended on were "in active development."
That last phrase was a promissory note.

This is the redemption.
The [Nasdanika Model Tower](https://nasdanika.com/models.html) is published: twenty-nine models building with generated documentation sites, all of them stating their intent - the WHAT - in the open. 
A few models are still to be published - in source-only form
The models will be refined on first use, as all models are; refinement is a straightforward process once the structure exists.
What follows is the argument of the first story, resumed with the receipts in hand: floor by floor, what each level of the tower delivers, why it belongs to AI literacy, what regulators and standards bodies are asking for at that level, and what the incumbents - tribal knowledge, office documents, wikis - offer in its place.

I am not a lawyer and none of this is legal advice.
It is an engineer reading regulatory texts the way engineers read specifications: looking for what would have to be true of our systems for the requirements to be satisfiable.

## How my definition of AI literacy fell apart

When I built the [agent model](https://agent.models.nasdanika.org/) and the [MCP model](https://mcp.models.nasdanika.org/), I thought AI literacy meant agentic vocabulary: knowing an agent tool from an MCP server, similarity search from a vector database, a capability from the provider that happens to implement it.
That literacy is real and its absence is expensive - I opened the first story with the meetings it wastes.

Then I started working through the [AIGP preparation course](https://www.udemy.com/course/aigp-cert) by [Jacob Bushong](https://www.linkedin.com/in/jacob-bushong/), and the definition fell apart in my hands.
The material that certifies you as an AI governance professional is not mostly about AI.
It is about ownership, lifecycle, documentation, risk, decision records, oversight, incident response - which is to say, it is about software engineering, done properly and provably.
My estimate after sitting with it: ninety percent of AI literacy has nothing to do with AI.
It is the engineering discipline that AI, and now AI regulation, applies pressure to.

The pressure matters because the old ways cannot take it.
Tribal knowledge, office documents, and wikis were always a lossy substrate for engineering knowledge; before, the loss was absorbed by patient humans re-deriving what the documents forgot.
Regulation removes that slack.
The EU AI Act's Article 4 has required providers and deployers to ensure AI literacy in their staff since February 2025 - and the same act's documentation, record-keeping, and oversight articles require the organization to *show its work* in ways a wiki simply cannot.
The US landscape, meanwhile, is churning - Colorado passed an EU-flavored AI act in 2024 and repealed and replaced it with something much narrower in 2026 - which is its own lesson: texts will keep moving.
The engineering fundamentals underneath them are the common denominator that doesn't.

## Field notes: five failure modes

Before the tower, the pathology.
These are patterns, not incidents; I have watched each of them more than once, across organizations and years, and I describe them here without names because the point is that they are everywhere.

**Code without a role.** Tens of thousands of lines of generated TypeScript or Python, handed to a Java team by someone who holds no role on the receiving project.
The generation took an afternoon; the review debt landed on people who never asked for it.
A senior architect summarized it better than I could: anybody can generate tons of code now - what teams need is *forward architecture*.
The generation was not the failure.
The absence of any structure that could answer "who is this person to this project, and who decided this belongs here" was.

**Decision by committee, settled by the boss.** A group with no stake in the outcome debates; the boss doesn't participate, then overrules.
Sun Tzu described the ruler who commands the army from the palace more than two millennia ago.
The modern version produces a decision with no recorded alternatives, no criteria, and no owner - which, we will see, is now a compliance problem and not merely a cultural one.

**Pictures for architects.** I once generated a full documentation site - diagrams *and* element descriptions, linked and versioned.
I was told the descriptions were unnecessary: just pictures, talked through in a meeting.
Talk-through architecture leaves no trace an auditor can follow.
I do not believe that process survives contact with an AI audit, and I would not want to be the one defending it.

**The audience failure.** A hackathon produces an AI-assisted prototype.
The runtime executes; business and leadership are delighted.
The audiences that were never addressed - architecture and the developers who must productionize it - receive the code as a fait accompli with a two-week deadline.

**Alternative suppression.** Office formats hold one proposal at a time, and people fuse their ego to the proposal they authored.
The dominant voice - a boss, a golden child - pecks the other alternatives to death, and the rejected options are not archived but *erased*: the next version of the deck simply doesn't contain them.
AI regulation is unusually hostile to this habit, because rationale, assumptions, and trade-off decisions are exactly what technical documentation must now retain.

**Consensus as expertise averaging.** A team builds an agentic application with a user interface.
One member has spent years inside UI machinery - editing domains, command stacks, undo/redo - and knows that reversibility is not polish but a load-bearing requirement for AI-driven interfaces: when an agent acts on a user's behalf, clean undo is the difference between oversight and cleanup.
The teammates are excellent engineers from a different stack; the UX specialist knows UX, which is a different discipline from UI internals.
The proposal goes to consensus, and because the majority has never met a command stack - or the emerging agent-to-UI protocols built on exactly this pattern, of which [Google's A2UI](https://a2ui.models.nasdanika.org/) is the most prominent - undo/redo is voted out of scope.
Nobody behaved badly, and nobody was overruled; that is what makes this failure mode distinct from the committee one.
The decision procedure simply had no way to represent that expertise is unevenly distributed: a flat vote averages decades of industry knowledge with its absence and records the result as agreement.
There is a regulatory edge here too.
The AI Act's human-oversight provisions (Article 14) assume the overseeing human can disregard, override, or reverse an AI system's output; an interface with no undo machinery makes reversal a slogan rather than a capability.
A vote of the unfamiliar just discarded a requirement none of the voters knew existed.

Add the everyday waste: the twenty-person workshop where two UX designers, who know more about UX than the other eighteen combined, get the same share of the flat conversation as everyone else.
Every discipline has its [coup d'œil](https://en.wikipedia.org/wiki/Coup_d%27%C5%93il) - the practiced glance that sees at once what others reconstruct slowly.
A workshop flattens all of them into talk, captures a fraction, and forgets the rest by the following sprint.

None of these are AI failures.
All of them become AI *liabilities*, because AI both accelerates the damage (generation is free, review is not) and attracts the regulation that demands the missing structure.

## The tower

The [Model Tower](https://nasdanika.com/models.html) is a stack of small metamodels - [micro-models](https://nasdanika.com/stories/2026/micro-models.html) - in which each floor extends the floor below and adds exactly one concern.
By the top, an element is documented, owned, access-controlled, staged, costed, decided, governed, worked, architected, and threat-modeled, without any single model defining more than its own concern.
The models are small enough to read in a sitting, formal enough for tools and agents, and composable across repositories the way Maven modules are - because that is literally what they are.

Read it bottom-up as an AI literacy curriculum.
Each floor is one competency the regulations assume you have, and one question the office-document world cannot answer.

### NxCore - provenance and time

The base floor: model elements with documentation as structure, a time dimension including relative time, and provenance via nested markers - every element and every computed value can carry the tree of sources it came from, down to Git origin and commit ID, which trace to the people who made the commits.
That is ownership tracking in its simplest form, and temporals are lifecycle in its simplest form, both present from the first floor up.

The regulatory resonance is direct: the EU AI Act's record-keeping and traceability provisions (Article 12), and technical documentation that must be kept current (Article 11, Annex IV), all presuppose that statements have knowable origins.
A wiki offers page history - who last edited the *page*.
It has no opinion about where the *facts* on the page came from, which is the question that matters.

### Role - ownership as data

Undergoer, Role, Actor: the vocabulary of responsibility, as data rather than as a names column in a table.
Role also extends the documentation classes, so every section of a document can answer "whose is this."

Explicit ownership is not optional decoration anymore.
The AI Act requires deployers to assign human oversight to named natural persons with the competence, training, and authority to exercise it (Article 26).
US banking's SR 11-7 has required named model owners for over a decade.
NIST's AI RMF makes accountability structures a governance function.
And separation of duties - a control frameworks ask for everywhere - stops being an attestation exercise and becomes a *query* over role data: show me every element where the same actor holds both of these roles.

### IAM - audiences, human and otherwise

Who may see and do what - with people and agents as first-class subjects of the same model.
This floor also introduces the concept the audience failure mode above lacks: a *target audience* as a modeled thing, not an afterthought.
One source generates for multiple audiences in multiple formats - leadership, architecture, developers, auditors - at element granularity, in multiple languages if needed.

Cybersecurity requirements (Article 15 and everything downstream of it) assume access control exists and produces evidence.
The 2026-specific twist is non-human identity: your agents need the same who-can-do-what discipline your people do, and a model that treats agents as subjects from the IAM floor up gets that for free.

### Seal - proof and protected distribution

Cryptography on top of IAM: signatures for non-repudiation, encryption so models can be distributed yet protected, and feature variants so that the "multiple audiences" story above is enforceable, not aspirational.
Explainability guidance across frameworks converges on the same demand: an explanation fitted to its audience.
Transparency obligations (Article 13) require information appropriate to the deployer's needs and competence.
Hand-recutting the same deck per audience produces versions that diverge by Friday;
generating audience variants from one sealed source produces explanations that agree with each other and can prove who issued them.

### Lifecycle - stages with receipts

Stages and transitions as data.
Combined with the floors below, transitions acquire guards: who may fire this transition is an IAM question, stage ownership is a Role question, and an approval gate is a guard demanding a *signed* sojourn - an approval with a receipt, rather than a "status: approved" cell whose author and date nobody can reconstruct.

Every serious framework is lifecycle-shaped: SR 11-7's development-validation-deployment-monitoring-retirement arc, ISO/IEC 42001's lifecycle processes, the AI Act's post-market monitoring (Article 72).
The office-document version of lifecycle is a status column and a meeting where someone says it's basically done.

### Accounting - cost as a first-class dimension

A lightweight double-entry model, recently admitted to the tower's spine, that can attribute cost - building, running, reviewing - to any element in the graph, and therefore to any *alternative* under consideration.

No statute mandates double-entry accounting for engineering artifacts.
But every risk-based, proportionate decision the statutes do demand presupposes that someone can compare costs - and many technologists demonstrably cannot.
"We should use MCP" is, in most rooms where it is said, a statement about what is currently hot, not a comparison of review cost, running cost, approval cost, and operational risk against the alternative of a plain tool call.
In a year when cloud AI capacity has become a genuine constraint the cost of running is no longer a rounding error, and cost illiteracy is an AI literacy gap in the most literal sense.

### Decision - alternatives that survive

Multi-criteria decision analysis: alternatives, criteria, multiple experts, with deciders drawn from Role, confidentiality of evaluations from IAM (Delphi-style, so the boss's score does not anchor everyone else's), and decision workflows from Lifecycle.
"Multiple experts" carries more weight than it sounds: expertise is data too, and evaluations can be weighted by demonstrated competence in the criterion at hand.
That is the structural repair for consensus-as-averaging - the UX specialist's weight peaks on usability criteria,
the UI veteran's on interaction machinery, and neither cancels the other with a vote on a subject they have never worked in.

Here the regulatory text is startlingly specific.
Annex IV of the AI Act requires technical documentation to describe key design choices *including the rationale and assumptions made*, and decisions about *trade-offs* between technical solutions.
Article 86 gives affected persons a right to explanation of the role an AI system played in decisions about them; fundamental rights impact assessments (Article 27) ask what was considered and why.
Counterfactual questions - flip a criterion, what changes? which alternative wins if we weight cost double? - are the standard toolkit of explainability practice, and they are only answerable if the alternatives and criteria still *exist* as data.
SR 11-7's "effective challenge" is the same demand in banking dialect: challenge that leaves no record is indistinguishable from no challenge.

Now reread the failure modes: the committee that debates while the boss overrides, the alternatives pecked to death and erased from the next deck, the flat vote that averaged expertise away.
Organizations where the only decision procedures are debate, consensus, and boss override are not just culturally impoverished.
They are accumulating systems whose design rationale cannot be produced on request - and producing it on request is what the law now asks.

### Binding - decisions that cannot silently drift

Analysis is one floor; commitment is another.
Binding records which alternative was committed into which variation point, by whom, based on what analysis and what other decisions.
This is the architecture decision record done properly: wired to the element it decides, so that drift between the decision and the reality is *detectable* rather than archaeological.
Article 11 requires technical documentation to be kept up to date; binding is what makes "up to date" a checkable property instead of a hope.

### Governance - the frame the AI frameworks assume

Frameworks, policies, controls, risks, evidence, waivers - modeled on the patterns of ISO management systems, NIST, and OSCAL.
Risk acceptance traces to the Decision floor; waiver approval is a Role engagement with an owner and an expiry.
This floor is the basis for AI governance because AI governance *is* governance, specialized: a quality management system (Article 17), an AI management system (ISO/IEC 42001), a controls-and-evidence discipline.
Organizations that maintain policy PDFs and a controls spreadsheet reconciled annually under audit duress do not have a governance system; they have governance-flavored documents.

### Work - the trace from finding to fix

Work items attachable to anything: a governance finding traces to remediation work; work is staged, owned, and access-controlled by the floors below.
Two literacy points hide here.
First, Article 9's risk management is required to be a *continuous iterative process* - a process leaves a work trail or it didn't happen.
Second, estimated work on alternatives is how cost sneaks back into decisions even where no one will write a ledger: choosing an MCP server is also choosing weeks of security review and approval workflow, and "so many hours" is accounting by other means.
A decision floor that can hold estimated work per alternative makes that visible *before* the commitment, which is precisely when it is worth knowing.

### Architecture - interpretable by construction

Elements with containment, reified relationships, and kinds as instance data; C4, ArchiMate, and TOGAF vocabularies load as catalogs rather than competing metamodels. Every architecture element is transitively workable, governed, staged, access-controlled, owned, and documented with provenance - the whole tower under every box on every diagram.

Annex IV asks for a description of the system architecture explaining how components build on and feed into one another.
"Just pictures, talked through with architects" is the null implementation of that requirement.
Interpretable architecture - where the diagram is a *view of data* that tools, auditors, and agents can traverse - is the one that survives questioning.

### Threat - the security lens on the same elements

Assets, threats, weaknesses, trust boundaries, with STRIDE, ATT&CK, ATLAS, and the OWASP lists loading as taxonomy catalogs.
The crucial move: an asset *is* an architecture element seen through the security lens, not a copy of it maintained by a different team in a different tool, which is how the estate actually drifts out from under its threat model.

### The rooftop: where AI itself lives

Above the spine, models branch off at the floor they need.
The agentic stack - [AI Governance](https://ai.governance.models.nasdanika.org/), then [Agent](https://agent.models.nasdanika.org/), then [MCP](https://mcp.models.nasdanika.org/) - grounds AI systems, model and dataset assets, evaluations, incidents, and oversight in the threat floor, so an agent is *governed by construction*: risk tier, oversight mode, and threat surface exist before a single call executes.
Serious-incident reporting (Article 73) has somewhere to accumulate.
And the vocabulary literacy the first story was about lives here too, as data: an agent tool and an MCP server are different classes with a modeled relationship, which is more than most glossaries can say.

The pull stack - [Capability](https://capability.models.nasdanika.org/), then [Product Management](https://product-management.models.nasdanika.org/), then [Org Design](https://org-design.models.nasdanika.org/) - is where the organizational literacy lives: personas articulate concerns, capabilities are pulled by concerns, and people get organizational coordinates, decision rights, and separation of duties.
I want to dwell on one sentence of statute here, because it is the most underrated sentence in the AI Act for anyone running a literacy program.
Article 4 does not say "train your staff."
It says literacy measures must take into account staff's technical knowledge, experience, education and training, *and the context the AI systems are to be used in*.
That is a persona definition.
The statute is describing pull, not push.
A program that broadcasts the same firehose of content such as third-party generic AI trainings is not failing at enthusiasm; it is failing at Article 4's own model of how literacy reaches people.
Persona-scoped views generated from a model are not a nice-to-have on top of a literacy program; they are what the obligation, read carefully, actually describes.

## Estates: where the tower pays for itself first

Aspect floors are potential energy. Estate models are where it converts.

The [Maven model](https://maven.models.nasdanika.org/) branches off the threat floor: modules as assets with computed ownership and transitive dependency graphs.
A security leader I spoke with put the pain plainly: transitive vulnerabilities, and deciding which ones to fix *first*, is a major unsolved nuisance at enterprise scale.
Scanner output is a flat list; prioritization needs the graph - who owns the module, what depends on it, where it sits relative to trust boundaries, what it would cost to move.
Because the Maven model inherits ownership, governance, work, and threat from the tower, a vulnerability sweep is a query with owners and costed remediation attached, not a quarterly CSV re-triage.
The same structure is what SBOM obligations (the EU Cyber Resilience Act, US federal procurement rules) and financial-sector third-party registers (DORA) keep asking for from different directions.
I have done the scan at scale before years ago - sixty thousand repositories with hundreds of thousands of branches into one federated dependency graph - the approach is proven; the tower is what makes the result *governable* rather than merely impressive.

The [BW5 model](https://bw5.models.nasdanika.org/) does the same for a very different estate: Tibco BusinessWorks 5, the classic dying-vendor-runtime problem, modeled down to activity level.
I have scanned and analyzed BW5 estates before as well, years ago.
Two things make this more than nostalgia.
First, [modernization](https://docs.nasdanika.org/practices/legacy-modernization/index.html) and tech-debt planning become estimable: dead-process detection, complexity metrics, migration cost per component, all with the ownership and work floors underneath.
Second - and this surprised me when I saw it - a BW process is structurally an agentic system: activities and transitions with XPath conditions are tools and control flow with guards.
An organization that learns to model, govern, and modernize its BW estate is rehearsing, on twenty-year-old technology, exactly the discipline its agents will need.
The legacy work and the AI work are the same literacy.

One serious engagement on each - a Maven sweep, a BW estate, an agentic system - is what these models need to move from published intent to refined instrument.

## The method, because it is also the message

The mainstream of AI-assisted development generates volume: low-level code by the tens of thousands of lines, which is how the first failure mode above comes into the world.
My use of AI inverts this. I ask AI to generate *Xcore metamodels* - distillations of industry knowledge small enough to review in an afternoon. 
From those, low-level artifacts are generated deterministically: Java classes, loaders, documentation sites.
The human reviews a page of structure, not a warehouse of output; determinism does the tedious part with zero marginal model cost, which matters in a capacity-constrained year.
With [Xcore model archetype](https://github.com/Nasdanika-Archetypes/xcore-model) a new model site can be published literally in minutes.

Clausewitz called the commander's gift *coup d'œil* - the glance that grasps the field.
The division of labor that works is: the human provides the vision (the tower and its floors are a human judgment about what matters), the AI conducts reconnaissance - surveying industry knowledge, distilling it into candidate structure, generating the connective tissue.
And AI helps keep the *body of knowledge* coherent in a way I think of as a hologram, or chain mail: the models overview page gives the high-level picture, each model's documentation explains itself and its relations to its neighbors, and every fragment implies the structure of the whole.

Two objections deserve direct answers. 
*"This is Eclipse."* No: Nasdanika is pure Maven with an Xtext plugin for code generation; Eclipse is optional, Xcore is needed only for authoring new metamodels, consuming them is plain Java with Maven dependencies - and AI assistants are notably fluent in Xcore, which has quietly become one of its best qualities.
*"One-person bus factor."* Yes, today, and I will not pretend otherwise.
It is a cost/risk/benefit decision like every dependency decision - and I note, with some satisfaction, that the tower is precisely the structure in which you would record that decision: alternatives, criteria, costed risk, an owner, and a signature.

## Literacy with receipts, standing

The first story ended by predicting that hand-authored literacy artifacts would "fall apart the first time somebody asks the question regulators have taught us all to ask: how do you know?"
The tower is my answer, published where anyone can inspect it: vocabulary from models, governance definitions from models, org bindings from models, decisions with their alternatives still attached, architecture that tools can interrogate, estates swept into graphs with owners - every view derived, every derivation linked back to source.

Twenty-nine models build today.
A few models are still source-only; the readmes are catching up with the newest floor; everything will be refined by use.

Start at the [models page](https://nasdanika.com/models.html), open your favorite AI assistant, describe yourself as a [persona](https://product-management.models.nasdanika.org/references/eClassifiers/Persona/index.html) with concerns (goals, needs, painpoints) and ask "how this can help in addressing my concerns"? 
You can find a few examples on the [audiences page](https://nasdanika.com/audiences/humans/index.html).


