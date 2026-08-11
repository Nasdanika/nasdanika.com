At the center (the Nasdanika logo) is the model: not one monolithic model, but a federation of [micro-models](stories/2026/micro-models.html).
Each micro-model is small enough to read in one sitting, formal enough for tools and agents to operate on, and composable with the others: models reference and extend each other across repositories the same way Java modules reference each other across Maven. 
Micro-models are cheap to author: the [Xcore archetype](https://github.com/Nasdanika-Archetypes/xcore-model) instantiates a new model project in minutes, and AI assistance drafts the first cut from a conversation.
They are cheap to publish: the [Nasdanika CLI](https://docs.nasdanika.org/nsd-cli/index.html) generates a documentation site with visualizations and search, and GitHub Pages hosts it[^xcore-doc]. 
Cheap to author and cheap to publish is what makes "one micro-model at a time" a realistic adoption path rather than a slogan.

Around the model are three interaction surfaces.

## <img src="images/human.svg" alt="" aria-hidden="true" class="arc-icon"> Humans

People author and consume through the tools they already use: Draw.io diagrams, Excel spreadsheets, Markdown, Confluence, PowerPoint, and generated documentation sites like this one.
The Nasdanika CLI provides fine-grained commands and command pipelines; situational Web UIs, served directly by the CLI, appear for a task or a group of tasks rather than as an uber-portal; and a VS Code extension wraps the CLI so the same capabilities are available without leaving the editor.
AI assistance is a human surface too: chat that answers questions about the model and, with commands, edits it.

## <img src="images/sparkle.svg" alt="" aria-hidden="true" class="arc-icon"> AI agents

Agents do not get raw files; they get JSON schemas and tool definitions generated from the metamodels, and JSON generated from the models. Semantic contexts scope what an agent sees to exactly the slice of the model and metamodel it needs, so agents stay focused and constrained. 

## <img src="images/systems.svg" alt="" aria-hidden="true" class="arc-icon"> Systems

Connectors load and cross-reference data from the systems where work already happens: [GitLab](https://gitlab.models.nasdanika.org/), [Jira](https://jira.models.nasdanika.org/), ...
Models are stored in Git, which provides file-level version control and distributed, federated ownership; feature-level [change recording](https://change.models.nasdanika.org/) and [telemetry](https://telemetry.models.nasdanika.org/) stored beside the model provide the finer grain that Git alone cannot.

One model at the center, three audiences at the edges, each meeting the model through its own surface.
The gaps between the arcs are deliberate: the list of surfaces is open.

[^xcore-doc]: See [Xcore-doc template](https://github.com/Nasdanika-Templates/xcore-doc) for details.