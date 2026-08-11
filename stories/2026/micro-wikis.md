*A wiki gives you depth without a spine. A model gives you a spine without depth. A micro-wiki is what happens when you connect them.*

## The attribute that would not stay a description

Every modeling tool I have ever used, and every metamodel I have ever built, makes the same quiet assumption: documentation is an attribute of a model element. A description field. A doc annotation. At best a Markdown file that renders into the element's one generated page.

One attribute is enough to break that assumption. Consider the status of a Jira issue. On the model it is a single feature of a single class. In any real organization it carries pages of documentation: what each status means, who may move an issue between them, what automation fires on each transition, how statuses map across projects that customized the workflow. And behind the prose sits a structured artifact, a state machine, that is documentation too, just not the kind that fits in a string.

When pages of content and a state machine hang off one attribute, documentation is not an attribute of the element. It is a space anchored at one.

## What forced the issue

Recently a partner organization shared a Git repository of guidelines relevant to a system I had modeled: what is permitted, what is not, and why. I pointed an AI agent at the guidelines and asked it to update the documentation of every affected model element with a section summarizing what the guidelines require of that element, with references back to the source.

It did an excellent job, and two things fell out. The first was practical: the guidelines became legible. Instead of a corpus I had to internalize and mentally join against my design, every element now explained, in place, what the rules meant *for it*. Explaining the constraints to stakeholders stopped being an exercise in citation archaeology; readers of [When Architecture Reads the News](https://medium.com/nasdanika) will recognize the shape, because a guideline corpus is exactly the kind of news whose natural consumer is a repository, not a feed.

The second was structural. Element documentation stopped being a page. The elements touched by the guidelines now wanted a governance page next to the conceptual page, next to the examples page, next to the how-to page. Each element had become a small documentation site of its own. The model kept doing what only a model can do, holding the typed, validated, navigable structure above them. The pages did what only pages can do, going as deep as the subject demands.

That is the pattern I am naming a micro-wiki: every model element, down to a single attribute or reference, anchors its own documentation space with multiple pages and structured artifacts, while the model above it provides the site map.

## Depth without a spine

Wikis are where enterprises keep depth today, and structurally a wiki is a single untyped tree of pages with untyped links between them. Whether a page describes a system, a decision, a meeting, or a lunch menu is visual convention, not semantic content. The site map, in the sense of "how does this space hang together and where does a new page belong," lives in the heads of the two people who tend the space. When they leave, the space becomes an archaeological site. I have written elsewhere that the structure in wiki content is real but latent, and that you can mine it out progressively. That is the wiki-to-model direction. This piece is the other direction.

## A spine without depth

Models have the opposite problem, and the modeling culture built its habits around it. Because documentation was an attribute, it stayed attribute-sized. Javadoc is the honest expression of the habit: one generated page per element, prose crammed into comments, and anything longer exiled to a wiki where it immediately detaches from the element it describes. The deepest knowledge about a model, the edge cases, the rationale, the compliance obligations, the state machine behind a status field, ends up in exactly the place with no spine.

So the enterprise runs two systems that each hold half of what the other needs. The model knows what things are and how they relate, and says almost nothing about each. The wiki says plenty about each thing and has no reliable idea what the things are.

## The micro-wiki

Connect them and the division of labor is clean. The model owns structure: typed elements, typed relationships, validation, generated diagrams, generated navigation. The documentation space anchored at each element owns depth: as many pages as the element deserves, in whatever form the content demands, prose, diagrams, state machines, worked examples, governance sections.

The property that makes this more than "put links in your description fields" is that the site map is generated from the model, so it cannot lie. Navigation between micro-wikis follows the model's references, not somebody's memory of where a page was filed. When an element moves or is renamed, its space moves with it. And because the [micro-model stack](https://medium.com/nasdanika) is federated across Maven artifacts, the documentation federates the same way: an element's space can cross-reference the spaces of elements in the models it depends on, sites linking to sites, with the dependency graph as the routing table.

The sizing rule from micro-models applies here with a pleasing symmetry. The core concepts of a model must fit into one home-page diagram; the home page of an element's micro-wiki must stay one page. Depth is behind a click, always opt-in, never charged against the newcomer. A micro-wiki that front-loads its governance section onto the element's landing page has failed the same test as a metamodel that puts forty classes on its home diagram.

## Prior art, and where it stops

The industry has been converging on this from three directions without naming the destination. [Backstage TechDocs](https://backstage.io/docs/features/techdocs/how-to-guides/) attaches docs-as-code to catalog entities, which is the closest existing practice: documentation anchored to a node in a typed graph. But the granularity stops at the entity, the catalog's type system is fixed rather than an extensible metamodel, and there is no notion of an attribute deserving its own space. Data catalogs, dbt, DataHub, Collibra, already accept column-level documentation as normal, which quietly concedes the whole argument: if a database column merits its own documented existence, so does any model feature. And topic-based authoring, DITA and its maps, understood decades ago that documentation is a graph of small units bound by a map; it just left the map to be maintained by hand. The micro-wiki position in one sentence: TechDocs granularity is too coarse, data catalogs prove the fine granularity is wanted, and the DITA map should be generated from the model rather than curated by a human.

## Why now: agents need addresses

The reason this stops being a documentation-hygiene nicety and becomes infrastructure is AI. An agent asked to apply a guideline corpus to a design needs two things a wiki cannot give it: an address space (which element does this rule constrain, and where exactly do I write the summary) and provenance (what do I cite). The model provides the addresses; the micro-wiki provides the room to write; the references provide the audit trail. The guideline exercise that seeded this piece was cheap precisely because the structure already existed: the agent did not have to invent an information architecture, it had to fill one in. And when the guidelines change, the change is news, it propagates along the graph, and it lands in exactly the micro-wikis of the affected elements as a reviewable diff.

Populating documentation used to be the cost that killed it. An agent working over a model turns pages of per-element documentation from a quarter-long technical-writing project into an afternoon of review.

## The failure mode is the old one

A micro-wiki can rot like any wiki; anchoring pages to an element does not make their contents true. The mitigations are the boring, known ones: generated structure cannot drift, so drift is confined to page contents; citations back to sources make staleness detectable; and agents that write sections can also be asked to re-verify them when the cited source changes. What the micro-wiki removes is the failure mode that actually kills enterprise documentation, which is not wrong pages but unfindable ones.

## The point

Documentation is not an attribute of a model element. It is a space anchored at one. Give every element that earns it, down to a single attribute, its own multi-page space, let the model generate the site map, and keep the element's landing page inside the fifteen-minute budget. Wikis mine structure out of pages; micro-wikis grow depth under structure. The enterprise needs both directions, and the model is the spine either way.
