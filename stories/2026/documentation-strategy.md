*Years ago I was part of a documentation and process improvement effort that produced diagrams and no improvement. I went home and built a metamodel.
It grew too complex, and I did not yet have the ideas that would have saved it.
Recently the same conversation found me again, and this time the missing pieces exist.
This is a story about receipts, and about why the standard fix for documentation chaos cannot work no matter how good the people running it are.*

## The meeting that recurs

There is a meeting that happens in every large organization.
The subject line says something like "documentation strategy", and the content is a lament: different groups want different documents, in different formats, in different places, and nobody can find anything.

The engineers want documentation next to the code, generated from the artifacts it describes, versioned with the things it documents.
The architects want diagrams in the review queue. The project people want status in the wiki.
The risk people want evidence in the system of record.
Leadership wants one tool, because two tools is confusion, and picks the wiki, because that is the tool leadership uses.

And then the low-level details assert themselves. Documentation generated from repository artifacts does not flow into the wiki.
Documentation that lives in the repository is invisible to everyone who does not use the repository, which is most of the organization.
So the mandate produces neither consolidation nor coverage.
It produces copies, staleness, and a new genre of meeting: the one where people discuss why the documentation strategy is not working.

That recent mentioning of documentation strategy reminded me of the past activity with no progress. Which is why I am writing this.

## Take one: the model I built too early

Years ago, at a previous employer, I participated in a process improvement effort.
The method was the standard one: gather smart people, interview practitioners, draw diagrams of the process, publish the diagrams.
The outcome was also the standard one: nothing changed.
The diagrams described a process that nobody exactly ran, they started aging the day they were published, and there was no mechanism by which a picture on a wiki page could exert force on how work actually flowed.

I thought the problem was fixable and the fix was structural, so I built a metamodel: document types, processes, engineers, increments, issues, releases, the relationships between all of them.
It is still public, in the [Nasdanika engineering model](https://github.com/Nasdanika/engineering/blob/main/model/model/engineering.ecore).
You can open the file and watch my past self discover the problem the hard way, one EClass at a time.

The model worked, in the narrow sense.
I modeled several processes with it and generated documentation sites from them.
And it failed, in the sense that matters: it grew too complex, and organizational adoption was never feasible.

Looking back, the failure had specific causes, and I want to name them, because "modeling does not work in the enterprise" is the lazy conclusion and it is wrong:

* **It was a monolith.** One metamodel tried to hold everything: documents, processes, people, issues, releases. Every new concern made every existing concern harder to understand. I did not yet have the concept of a [tower of micro-models](https://www.nasdanika.com/models.html), where each concern is a small model that fits in your head and extends the floor below it.
* **The authoring surface was hostile.** Populating the model meant XML or tooling that only I would tolerate. There was no [Groovy DSL](https://docs.nasdanika.org/core/groovy/index.html) through which a tech lead could write down their team's process in an afternoon, in an editor they already use.
* **There was no org model to hang it on.** Processes do not float free. They belong to org units, cross org unit boundaries, and change when the org changes. I had no [organization design model](https://org-design.models.nasdanika.org/) to give processes an owner and an address.
* **Everything had to be hand-authored and hand-read.** No AI to interview a team and draft their process fragment. No AI to answer "what do I need to submit and where does it go" from the model instead of from tribal knowledge.

So the model sat in a repository, the organization kept improving processes by drawing pictures of them, and I filed the experience away.

## Take two

A recent mentioning of documentation strategy made me think - what's changed since the first take? 
How would it be different if done today?

The organizational response, here and everywhere, follows a pattern I have come to think of as process improvement theater, and I say that with sympathy, because every step of it is locally reasonable.
And I think today it would be very similar to what I experienced years ago.

A tiger team is formed.
The team interviews a handful of developers, perhaps five, out of an engineering population of a few thousands.
From the interviews it builds a story board, and from the story board a BPMN diagram of "the" process.
In some cases they build a journey map with happy and sad faces - I've been through this as well - an SDLC process with hundreds of activities and happy/sad faces next to them. 

The diagram cannot reflect reality, and not because the team is careless.
It cannot reflect reality because there is no single reality to reflect.
Thousands of developers run thousands of ad-hoc variations.
A diagram distilled from five interviews is not a description of the process; it is an average of anecdotes, a process that nobody actually runs, published in a place where nobody will consult it at the moment of need.
The wrong turn is not in the execution.
It is in the assumption that the deliverable is a picture.

A picture is not data.
You cannot query a picture for "every process step that consumes a System Context Diagram".
You cannot validate a submission against a picture.
You cannot generate a checklist, a template, or an agent tool schema from a picture.
You cannot even keep a picture true, because nothing that changes in reality has any obligation to update it.

## Three questions wearing one trench coat

The tool argument that anchors these meetings, wiki versus repository, Confluence versus Bitbucket/GitHub/GitLab, SharePoint versus everything, is unwinnable for a structural reason: it is three questions pretending to be one.

* **Document type.** What is this thing, semantically? A System Context Diagram. An interface specification. A runbook. A decision record. Types have required content, templates, examples, owners.
* **Format.** What are the acceptable serializations of that type? A System Context Diagram might be accepted as Visio or Draw.io, but not as PDF or PowerPoint. A specification might be Markdown or a generated site. Formats are properties of the type, and there can be several.
* **Storage and channel.** Where does an instance live, and how does it move? SharePoint is storage. A Git repository is storage. A wiki is storage. Email is a channel; it moves documents but it is not a place where documents live, and every organization that uses inboxes as a document store knows the cost. Some groups will require the wiki, others an attachment to a ticket, others a path in a repository, and within one organization all of these can be simultaneously correct.

Collapse these three into one question, "which tool is our documentation strategy", and every faction is right and the argument is eternal.
The engineers are right that generated documentation belongs with the artifacts.
The stakeholders are right that they will never open the repository.
Leadership is right that sprawl is confusing.
The problem is not that someone has the wrong requirements.
The problem is that the organization has no vocabulary in which the requirements can all be stated at once.

That vocabulary is exactly what a model provides. And, importantly, it is not a vocabulary I invented.

## The industry already named this problem

Documentation delivery is a recognized problem domain with decades of standards behind it.
ISO/IEC/IEEE 42010 and TOGAF say, in essence: a system has stakeholders (information security, architects, operations, business owners), stakeholders have concerns, concerns are addressed by views, and views are delivered to stakeholders over channels.
The documentation strategy meeting is, in standards terms, an argument about view delivery channels conducted by an organization that has no model of its stakeholders, concerns, or views.

Between the engineering model and the tower I made a second attempt at this, and it took exactly that shape: the [enterprise model](https://enterprise.models.nasdanika.org/) was created partly to address this problem, built on the TOGAF and IEEE vocabulary, with stakeholders, concerns, views, and views delivered as messages over channels.
It also aligns naturally with the newer [product management model](https://product-management.models.nasdanika.org/), where stakeholders and their concerns reappear as personas and their needs; the two vocabularies describe the same people from two directions.

So the type, format, and channel decomposition above is not a novelty; it is view delivery made concrete.
What the standards give is the vocabulary and a method.
What they conspicuously do not give is pragmatics: a cheap way for thousands of groups to state their own fragments, and machinery that pays them back with discovery, validation, and automation.
Frameworks that stop at vocabulary produce shelfware and certification courses.
Closing the gap between the recognized vocabulary and something a tech lead can use on a Tuesday is the entire project.

The enterprise model, for its part, is not a failed attempt and is not going anywhere.
It is deliberately language independent: it has no type system, which is exactly why it speaks in "kinds", and that is its job.
It stays as it is, a mental and reference model aligned to TOGAF and IEEE 42010, the thing the pragmatic machinery is checked against.

The tower, by contrast, is typed, and the enterprise model's concepts materialize in it floor by floor rather than as one more model.
Stakeholders and their concerns land at the very base, which means any element of any model, an architecture component, a decision, a process step, can declare who cares about it and why.
Roles are stakeholders; access-control subjects are stakeholders; the product management model's personas are stakeholders, with goals, needs, and pain points as their concern flavors.
Viewpoints frame concerns, and they come both as inline definitions and as catalogs, so an organization can curate its viewpoint library the way it curates any other catalog.
Representations, diagrams, presentations, UI, stay with the presentation models and get typed further on demand.

And here the story stops being only about documentation.
Consider what an AI assistant over models actually does, in this vocabulary: a user prompt is a concern, stated at runtime.
Given a catalog of viewpoints, the assistant matches the concern to a viewpoint and generates a conforming view, [agent-generated UI](https://a2ui.models.nasdanika.org/) being the vivid case.
That is concern-driven UI: viewpoints matched to concerns with human approval while the concern is being authored, automatically where that modality is enabled, and intermediate modalities in between depending on the authoring surface.
The documentation-strategy opportunity from earlier, AI that finds or generates a process step's inputs, is the same mechanism wearing work clothes: the input's document type is a viewpoint, the submission is a view, and the assistant generates it against the declared conventions.
One vocabulary covers the review board's Visio requirement and the dashboard that assembles itself in answer to a question.

## What the fix looks like

What I described piecemeal above assembles into something specific: a **federated model of organizational units and processes**, where processes and process steps declare their inputs and outputs as typed documents, with formats, storage locations, channels, and timelines.

Take a concrete, deliberately familiar example: an architecture review.

* The review is a process, owned by an org unit, with a declared timeline: submissions reviewed within ten business days.
* Its input is a document of type System Context Diagram. The type carries templates and examples, so a submitter is never guessing what "good" looks like.
* Accepted formats: Visio or Draw.io.
* Storage: the diagram is uploaded to a designated SharePoint location. Notification goes by email; email is the channel, SharePoint is the store, and the model says so explicitly.
* Output: a review record, its own document type, with its own storage.

Nothing in that description is exotic.
Every review board already has these rules; they live in onboarding decks, wiki pages of varying staleness, and the heads of the reviewers.
The change is that stated as a model, the rules become data, and data compounds in ways that prose and pictures cannot:

* **Discovery stops being archaeology.** "What do I need to produce, in what format, and where do I put it" is today a research project conducted over lunch conversations and dead wiki links; discovering what is required and where it lives is a huge share of the pain. From the model it is a generated site, a search hit, or a one-question chat.
* **AI assistance becomes concrete.** An assistant grounded in the model can find the right process, explain its inputs, hand you the template, check your draft against the type's requirements, and in the authoring direction, interview a team and draft their process fragment for a human to correct. This is the same modality as chat-over-the-model dashboards: the model gives the assistant something to be right about.
* **Pain points get an address.** Process improvement today collects complaints about "the process" in the abstract. With process steps as model elements, a pain point attaches to the specific step, and improvement work gets a ranked backlog instead of a mood.
* **Execution statistics accumulate.** Each execution of a process step can record its timing against the declared timeline. Whether the improvement actually improved anything becomes a before-and-after query over periods, not a testimonial.

And the model is **federated**, which is the part that makes it survivable.
There is no central modeling team drawing the one true process.
Each group states its own fragment: its units, its processes, its document types and where they live.
Fragments reference each other the way modules reference each other in a build.
The organization-wide picture is assembled, not decreed.
Where the tiger team samples five developers and averages, federation lets every group be the authority on itself, and disagreement between fragments is not a bug; it is documentation of reality, visible for the first time.

## What is different this time

I want to be careful here, because "I built it wrong once, therefore I now know how to build it right" is not automatically true.
But the specific causes of the first failure now have specific answers.

The monolith is gone: the Nasdanika models are now a [tower of micro-models](https://www.nasdanika.com/models.html), each small enough to fit in your head, from organization design down through work, decisions, lifecycles, and access control, so a documentation and process model does not have to reinvent people, roles, time, or evidence; it extends floors that already exist.
The authoring surface is a Groovy DSL in an ordinary IDE, not XML in a modeling workbench.
Generated sites make the model readable by people who will never know a model is behind the page they are reading.
And AI now sits on both sides of the loop, drafting fragments during authoring and answering questions during consumption, which attacks the two costs that killed adoption the first time: writing it down and looking it up.

## The pressure that makes this non-optional

The first time around, the case for documented processes was hygiene, and hygiene loses budget fights. Two things have changed.

**Regulation.** AI regulation in particular, and regulated industries in general, increasingly require that processes be documented as processes: quality management systems, technical documentation, evidence of who did what, when, under which controls.
A BPMN poster does not satisfy that; a model with typed inputs, outputs, and execution records is built for it.
Documentation of process is shifting from a virtue to a compliance artifact, and compliance artifacts get funded.

**Agents.** This is the sharper one. An AI agent's tool definition is, precisely, a declaration of inputs and outputs.
That is the entire interface. A process whose steps have declared, typed inputs and outputs is a process an agent can participate in: fetch the template, validate the submission, route it to the right store, chase the timeline.
A process that lives in tribal knowledge is invisible to automation.
Undocumented processes cannot be improved, and now they also cannot be delegated.
Organizations whose processes are stated as data will hand the tedious steps to agents;
organizations whose processes are folklore will keep paying humans to be middleware.
That gap compounds quarterly.

## The honest part

The models exist and are public, in their initial state; they will be refined by first use, and saying otherwise would be marketing.
There is prior art for every piece: typed document flows, generated sites, DSL authoring, process modeling.
Modeling a first real process, one review board, one intake, should take weeks, not quarters.

Adoption is the actual cliff, and I say that as the person who fell off it once. Nobody adopts a metamodel.
What can be adopted is one group deciding that its own intake process will be stated as data, generating its own "what to submit, where, in what format" page, and quietly becoming the easiest group in the organization to submit to.
Pull, not push.
The federation grows one fragment at a time or it does not grow at all, and no tiger team can mandate it into existence, which is exactly why it can work where mandates have not.

## Alternatives, and the cost of doing nothing

For completeness, the standard alternatives, each of which solves an adjacent problem:

* **Wikis and document stores** (Confluence, SharePoint) are storage. Necessary, insufficient: they hold documents without knowing their types, requirements, or place in any process. They are where documentation goes; they have no opinion on what documentation is owed.
* **BPM suites and process mining** draw or discover control flow, and process mining in particular is a serious tool where event logs exist. But they model the flow, not the documentation contract: not the typed inputs and outputs, formats, templates, and storage rules that this problem is actually about.
* **Internal developer portals** bring documentation next to services, which is real progress for the engineering slice, and mostly stops at the repository boundary, exactly where the non-technical stakeholders begin.
* **The tiger team** produces a diagram. See above.

The cost of doing nothing is not dramatic, which is what makes it dangerous.
It is another cycle of the recurring meeting.
It is discovery-by-archaeology as a permanent tax on every submission to every process.
It is regulatory findings answered with retroactive documentation sprints.
And increasingly it is watching competitors point agents at their processes while yours remain folklore.

I wrote my first answer to this problem too early, in the wrong shape, and left it in public where I could point at it later.
This is later. The second attempt is not a bigger diagram.
It is a federated model, built on floors that now exist, adopted one group at a time, by pull.

---

*The models referenced here live under [nasdanika.org](https://docs.nasdanika.org/) and [nasdanika.com](https://www.nasdanika.com/models.html). The first attempt is preserved in the [engineering model repository](https://github.com/Nasdanika/engineering/blob/main/model/model/engineering.ecore).*
