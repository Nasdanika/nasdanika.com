
## Personas

* [Leader](leader/index.html)
* [SME](sme/index.html)
* [AI Architect](ai-architect/index.html)
* [Consultant](consultant/index.html)

## Interaction Surfaces

Below is a list of human interaction surfaces.
Different personas may use different surfaces

* **Web UI** - generated static sites like this one or dynamic.
* **[Draw.io](https://docs.nasdanika.org/core/drawio/index.html)** - can be used as input, e.g. architecture diagrams, and output - generated diagrams of, say, SQL schemas.
* **[CLI](https://docs.nasdanika.org/nsd-cli/index.html)** - used directly, wrapped into VS Code Extensions, or as a server for Web UI.
* **[Markdown](https://markdown.models.nasdanika.org/)** - a structured text format which can be used to author documentation and models, including metamodels. It can also be used output format.
* **[MS Excel](https://excel.models.nasdanika.org/)** - humans can maintain data in Excel and that data can be loaded into models. [Resource Contents Filters](https://docs.nasdanika.org/core/capability/resource-contents-filters.html) can be used to map Excel data to model elements and features. Excel can also be used as an output format to generate reports. Case study - scan GitLab, generate a report containing footprint aligned to the org structure.
* **[Visio](https://visio.models.nasdanika.org)** - data from Visio diagrams can be loaded into models for further enrichment, resolving references, analysis, or to generate documentation sites.
* **[PlantUML](https://plantuml.models.nasdanika.org)** - PlantUML diagrams can be loaded into models. One example - [generation of documentation from PlantUML class diagrams](https://github.com/Nasdanika-Templates/plantuml-doc)
* **YAML, JSON** - models can stored to XML, YAML, JSON and binary formats and loaded from them. YAML and JSON can be edited directly by humans.
* **[Groovy DSL](https://docs.nasdanika.org/core/groovy/index.html)** - flexible, can be used with other surfaces do define prototypes. For example, Draw.io - ... 
* **[Confluence](https://confluence.models.nasdanika.org)** - humans can author Confluence resources which are then loaded into models.
