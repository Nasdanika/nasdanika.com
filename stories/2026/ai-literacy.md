*A glossary is a view. A view without a source of truth fails the explainability test.*

I have watched a team debate for half an hour whether they needed a vector database, when the actual question was whether they needed similarity search at all. Over a few hundred documents. I have watched "agent tool" and "MCP server" used interchangeably in the same design discussion, by people who were each certain the other meant what they meant. Nobody in these conversations was careless. The words simply did not bind to the same things in different heads.

Until recently I filed this under productivity: terminology confusion wastes meetings and money. Then I started preparing for the AIGP certification, and the framing shifted under me. AI literacy is not just an efficiency concern anymore. The EU AI Act's Article 4 has, since February 2025, required providers and deployers to ensure a sufficient level of AI literacy in their staff. I am not a lawyer and this is not legal advice, but the direction is unambiguous: literacy is moving from a nice-to-have into the category of things an organization must do and, when asked, must show it did. And anything an organization must show, it must be able to stand behind.

That changes what counts as literate.

## Three literacies, not one

The confusion I opened with is vocabulary illiteracy, and fixing it is necessary. It is not sufficient. Watching the regulatory material, I now count at least three layers.

**Vocabulary literacy** is knowing what an agent is, what a tool is, how retrieval relates to generation, and which of the three different things your organization calls an agent this particular one is. Its absence costs meetings, rework, and the occasional architecture built on a misunderstanding.

**Governance literacy** is knowing what a risk tier is, what human oversight means in practice, what an impact assessment covers, which controls apply to the system you are building, and what evidence looks like. Its absence costs audit findings, and increasingly it costs legal exposure. A team that can define MCP precisely but cannot say who accepted the residual risk of their agent is not literate in the sense that now matters.

**Organizational literacy** is knowing who owns what, who decides what, who must be in the room for which decision, and how accountability for an AI system actually flows through your structure. Its absence is why oversight exists on paper and not in practice: the committee is named in the policy and nobody can name the committee.

Courses teach the first layer in the abstract and gesture at the second. The third is not teachable in the abstract at all, because it is specific to your organization by definition. And this is the training gap that a subscription cannot close: the bindings are yours. Your approved models, your sanctioned frameworks, your risk appetite, your committees, your names for things.

## The glossary instinct, and where it goes wrong

The instinctive fix, once someone notices the vocabulary problem, is a glossary. I want to defend that instinct, because it is exactly right. A shared vocabulary is the cheapest coordination mechanism there is. Before you can review an agent architecture, before you can write a sensible policy about tool use, before two teams can reuse anything, the words have to mean the same thing.

Where the instinct goes wrong is the medium. A glossary lands on a wiki page, and a wiki page is a snapshot of somebody's understanding at the moment of writing. The field moves monthly; the page does not. Six months later it defines terms nobody uses anymore, omits the ones everybody argues about, and nobody can tell whether it reflects the current state or the state when its author changed roles. A flat list of definitions also cannot answer the questions people actually bring to it. What is the relationship between a tool and the protocol that serves it? Which models can I use for this classification task? Who approved this framework and when does that approval expire? Those are relational questions, and a page of alphabetized definitions has no relationships in it.

Under the old framing, that was an inconvenience. Under the new one, it is a failure mode with a name. If literacy is something you must demonstrate, then the artifacts of your literacy program are subject to the same question every other governed artifact faces: where did this come from? A glossary that is its own source, authored by hand, updated by whoever last cared, cannot answer. It would fail what I think of as the explainability test: for any statement, show me the source of truth it derives from, who owns that source, and whether it is current. We are learning to demand this of AI systems. It would be strange to exempt the documents that teach people about them.

## A glossary is a view

Here is the reframe I keep coming back to: a glossary is a view. Definitions, the relationships between concepts, and the organizational bindings (approved models, sanctioned frameworks, committees, internal naming) are structured data. The glossary everyone wants is one rendering of that structure. A concept diagram is another rendering. A "what am I allowed to use for X" lookup is another. An onboarding path for a new engineer is another. A governance-literacy primer scoped to what *this* team's systems actually require is another.

Views are wonderful. Sources of truth they are not, and treating a view as a source is precisely how organizations end up with five glossaries that disagree. The discipline is one rule long: derive the views from the source, and make every derived statement link back to it. Author the structure once and every view stays consistent, because they are generated from the same place and carry their lineage with them. Author each view by hand and they diverge from day one, which is the state most organizations are in.

The objection writes itself: are you seriously proposing every company build its own metamodel of AI concepts? No, and this is the part I care about most. The concepts are not organization-specific. What an agent is, what a tool is, what a risk tier is: that is industry common ground, and it belongs in open, shared models, maintained the way industry common ground is maintained. What is organization-specific is the instance: your bindings, your approvals, your committees, your local names. This is the Kubernetes pattern applied to concepts. Nobody defines what a pod is in-house. You adopt the industry model and supply your clusters, namespaces, and policies. Adopt the industry's concept models and supply your organization's bindings.

## What the source of truth looks like

This is not hypothetical, though I will be honest about what exists today and what is coming. I maintain an open-source [model of agentic AI concepts](https://agent.models.nasdanika.org/): agents, tools, MCP, models, retrieval, and the relationships between them, with a home-page diagram a newcomer can absorb over a cup of coffee and generated documentation behind every element. That covers vocabulary literacy, and it is live now.

The other two literacies get the same treatment. *A governance model (frameworks, policies, controls, risks, evidence, waivers) with an AI extension (risk tiers, oversight modes, model cards, evaluations, incidents), and an organizational design model that gives personas real coordinates (people, committees, responsibilities), are in active development as part of the same family of small, composable, federated models. When they publish, a "governance glossary" and an "who decides what" view fall out of them the same way the vocabulary glossary falls out of the agent model: generated, current, and linked back to source.* The models compose, which is the point: an agent in the vocabulary model is a governed system in the governance model, owned by someone the organizational model can name. Literacy in the composed picture is the "true" AI literacy the regulatory material is actually asking for.

And a model instance can do something no wiki page can: publish. A new model is approved, and instead of an announcement on an office-hours call that lands on a page nobody finds, the element's own page announces it, and the people who depend on it are subscribed to it. The glossary entry, the approval, the announcement, and the deprecation notice are the same element seen at different moments, each carrying its provenance.

## Why publish this before the models are done

Deliberately. The argument does not depend on my implementation, and the timing matters: organizations are standing up literacy programs right now, mostly by buying courses, and the derived-views-with-lineage discipline is cheapest to adopt before five hand-authored glossaries exist rather than after. The literacy program can keep the courses; courses are good at what they are good at. But the vocabulary should come from a model, the governance definitions should come from a model, the org bindings should come from a model, and every glossary, diagram, and primer derived from them should say where it came from.

Literacy with receipts, in other words. Anything less will read fine on a wiki and fall apart the first time somebody asks the question regulators have taught us all to ask: how do you know?