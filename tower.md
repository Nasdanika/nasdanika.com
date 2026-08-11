# The model tower

Each floor extends the floor below it, so everything above a floor inherits its vocabulary. Reading bottom-up, every floor adds one concern, and by the top an element is documented, owned, access controlled, staged, decided, governed, worked, and threat-modeled without any single model defining more than its own concern. Composition examples are given per floor; they compound as you climb.

## Bedrock

**[Ecore](https://www.eclipse.org/modeling/emf/)** with Java, EMF, and Git. Not a floor: what the ground is made of. Models and metamodels, code generation, storage, and versioning are twenty-year-old load-bearing technology.

## The spine

* **[NxCore](https://nxcore.models.nasdanika.org/)**: the base. Model elements with documentation as structure (Section, Content), the time dimension including relative time (temporal, period), and provenance via nested markers: every element and every computed value can carry the tree of sources it came from.
* **[Role](https://role.models.nasdanika.org/)**: ownership and responsibility. Undergoer, Role, Actor. Role defines its own Section and Content extending both the NxCore classes and Role, so documentation itself acquires ownership: every section of a document can answer "whose is this".
* **IAM**: who can see and do what, for people and agents alike. IAM likewise defines Section and Content extending NxCore and IAM, so documentation becomes audience-targeted: one source, generated for multiple audiences in multiple formats, similar to what Leanpub does for books but at element granularity. Crypto sits on top of IAM: signatures for non-repudiation, encryption so models can be distributed yet protected.
* **Lifecycle**: stages and transitions. Combined with the floors below, transitions get guards: who may fire this transition is an IAM question, and stage ownership is a Role question.
* **Decision** ([MCDA](https://mcda.models.nasdanika.org/)): decision analysis with multiple criteria, multiple experts, multiple alternatives. Deciders come from Role, confidentiality of evaluations from IAM (Delphi-style), decision workflows from Lifecycle.
* **Binding**: which alternative was committed into which variation point, by whom, based on what analysis and what other decisions. Architecture decision records that cannot silently drift from the architecture they decide.
* **Governance** ([base](https://governance.models.nasdanika.org/)): frameworks, policies, controls, risks, evidence, waivers, based on industry practice (ISO management systems, NIST, OSCAL patterns). Risk acceptance traces to Decision; waiver approval is a Role engagement.
* **Work**: work items attached to anything. A governance finding traces to remediation work; work is staged, owned, and access controlled by the floors below.
* **Architecture**: elements with containment, reified relationships, and kinds as instance data. C4, ArchiMate, and TOGAF vocabularies load as catalogs. Every architecture element is transitively workable, governed, staged, access controlled, owned, and documented with provenance.
* **Threat**: assets, threats, weaknesses, trust boundaries, with STRIDE, ATT&CK, ATLAS, and the OWASP lists loading as taxonomy catalogs. An asset is an architecture element seen through the security lens.

## The rooftop

Branches off the tower at the floor they need.

* **Agentic stack** (threat < AI Governance < [Agent](https://agent.models.nasdanika.org/) < MCP): AI Governance grounds AI systems, model and dataset assets, oversight, and incidents in the threat floor. Agent extends AI system, so agents are governed by construction: risk tier, evaluations, oversight, and threat surface before a single call executes. MCP models servers, tools, and catalogs, owned and documented like everything else. Runtime libraries (Anthropic, OpenAI, covering Ollama) execute agentic models directly or generate code for target runtimes. The capstone composition: an agentic system is an Actor from Role holding roles on undergoers across the model, its work is linked through the Work floor, and its threat analysis lives on the same elements it operates on.
* **Pull stack** (Capability < [Product Management](https://product-management.models.nasdanika.org/) < [Org Design](https://org-design.models.nasdanika.org/)): modeling for pull, not push. Personas articulate concerns, capabilities are pulled by concerns, and the org model gives personas organizational coordinates: a person extends a persona and provides capabilities with evidence.
* **Estate balconies**: [Maven](https://maven.models.nasdanika.org/) modules as threat assets with computed ownership and transitive vulnerability tracing; [BW5](https://bw5.models.nasdanika.org/) artifacts for model-driven legacy modernization down to activity level; Accounting, a lightweight double-entry model that inherits most of what it needs from the floors below, including cost attribution to any element in the graph.
* **Surfaces**: UI generation (Bootstrap, AlpineJS) with fine-grained UI governance via IAM, and the Diagram family for reading and writing Draw.io, PowerPoint, Visio, PlantUML, ODP, and PDF, inheriting access control, roles, and lifecycle like every other model.

The pattern throughout: when a model takes its position in the tower, the concerns it no longer needs to define disappear from it, because a lower floor already provides them. The tower gets taller and the models get smaller.
