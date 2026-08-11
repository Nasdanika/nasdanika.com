*Building AI-assisted dashboards with backward chaining over a capability registry*

Published on [Medium](https://medium.com/nasdanika/the-value-is-in-the-builder-not-the-chat-9cba89a3e1a3) on July 13, 2026.
Tags: Software Architecture, Artificial Intelligence, User Interface, Java, Tibco Businessworks

<img src="https://miro.medium.com/v2/1*Zf6umncoqQAy-Qtmlnh8YA.png" alt="When Architecture Reads the News" style="width: 100%;">

Every financial institution I’m a client of now has some flavor of AI in its dashboard. Merrill Edge ships “Dynamic Insights” — an AI-built personalized dashboard. Interactive Brokers lets me ask my portfolio questions in plain English and even connects my account to Claude via MCP. Bank of America’s Erica has pushed out over a billion proactive insights.

Meanwhile, none of the personal finance managers I’ve tried does what I actually need. They are aggregators with category tags, not accounting systems. I want double-entry, polymorphic account types, my data in my files, and reports I define. So I built an open-source [accounting model](https://accounting.models.nasdanika.org/) — and it is the perfect testbed for a different way to build AI-assisted dashboards.

The idea: don’t write the dashboard. **Resolve** it.

## Requirements, capabilities, backward chaining

I’ve written before about executable diagrams and agents operating on models. This is the same technique pointed at UI construction, powered by the Nasdanika [capability framework](https://docs.nasdanika.org/core/capability/index.html) — a conceptual extension of Java `ServiceLoader` and OSGi services. In Java, a service requirement is a type. OSGi adds text-based filters. The capability framework allows an *arbitrary object* as a requirement, and providers resolve requirements recursively. That recursion is backward chaining: start from the goal, chain through whatever capabilities can satisfy it.

Here is the whole architecture in one flow:

- Data sources and widget factories are registered as capability providers. A new data source or widget is just a new Maven dependency. Providers themselves can be loaded from databases or APIs through the same mechanism — invisible to client code.
- The client creates a `CustomerSession` requirement — customer id, preferences, device capabilities like screen size — and asks for a `Customer` object.
- Providers assemble that object polymorphically: profile from one source, accounts from many. A credit card account and a mortgage account are different types from different providers. Both accounts extend a loan account which extends a generic account. There might be mix-ins like US Account or Canadian account — the Java type system applied to business concepts. The model can be partially populated — recent balances eagerly, old transactions on demand — and how much you pre-load is a policy knob, not an architecture change.
- With the `Customer` in hand, you don't need a UI at all: run CLI commands over it, generate a monthly family finances report, feed tests with generated data.
- Or hand it back to the same engine as a requirement for a UI service. Dynamic app → [route builder](https://docs.nasdanika.org/core/http/index.html). Static report → [action model](https://html-app.models.nasdanika.org/). The resolution recurses down to individual page elements: accounts panel, transactions table, transaction details modal. At every level, the most specific provider wins — a credit card transaction gets a different modal than a debit card transaction simply because a more specific provider is in the dependency tree.

And AI? AI is a capability provider. One provider might rank widgets given your history. Another might write the insight panel. Another maps a chat message onto a requirement object — which means chat is just a thin front end to the same engine.

## I’ve built this before — for humans

Two decades ago I was an integration architect on a call center platform for a Tier-1 card issuer, replacing a system written in Visual Basic. The system it replaced had something remarkable for its time: a customer object model, progressively built per session. Some data was pre-loaded to make serving faster; the rest was loaded on demand. What to pre-fetch was driven by cost — my colleagues estimated that every second of serving time cost about a million dollars a year in salaries. The object model was a projection, not a replica: a credit card transaction had 73 fields on the back end; the object model carried 5. And agents never saw sensitive data in the clear — a customer’s SSN went into a masked field and stayed masked. The platform we built kept these principles: ESB-based transformation, caching and pre-fetch at the application layer, data minimization, a query engine — that GraphQL does nowadays, back then it was XML.

Reread the architecture above with that in mind. A session opens, an object model is progressively resolved. Eager/lazy population by customer value is pre-fetch by cost. Requirement-shaped resolution is projection — a widget gets 5 fields, not 73. And the agent — AI now, human then — sees only what its task requires. “What is my spend by category over the last six months?” doesn’t send my transactions to a language model; it resolves to a *spend widget configuration* (dimension: category, window: 6 months) from a catalog of widgets already wired to data sources. The model configures; it doesn’t touch the data. Only queries matching nothing in the catalog take a gated ad-hoc path — and there’s escalation, to more capable agents and to humans in premium tiers, exactly like every support chat you’ve used.

That’s the whole pitch, really: the AI-agent dashboard is a call center architecture. I built it for humans. This time the agent is AI. The rest is almost the same — including the part everyone is scrambling to solve right now, least-privilege access to financial data for LLMs, which call centers solved with masked fields twenty years ago.

## Why not Spring? Why not Python?

Spring resolves by type and qualifiers, mostly at startup. “Give me a details view for *this* transaction on *this* device for *this* customer” is a query over a live, polymorphic domain instance — reproducing that in Spring means hand-writing a strategy registry and most-specific-match dispatch, i.e., rebuilding the capability framework without the recursion. (The engine is plain Java, though — it can run *inside* Spring Boot, but it will lose JPMS service declaration in module-info.java because Spring is classpath, but there are other mechanisms)

Python gets you a Streamlit demo by lunchtime, and I mean that as a compliment. But the UI is imperative script, polymorphism is an if/elif ladder, there’s no typed model contract, and extension means editing code — not dropping in a dependency and letting resolution find it.

The chat-first alternative — let the LLM generate the dashboard — is the current fashion, and it’s the inversion I’m arguing against. Non-deterministic rendering of my financial data, priced per token, is not a foundation. An engine that is deterministic everywhere except where I explicitly invite AI in — that’s a foundation.

## Not just finance: persona-pull dashboards

Here is what convinced me the builder is generic. I also maintain a [product management model](https://product-management.models.nasdanika.org/) — product strategy as a federated, typed graph, where personas articulate concerns and capabilities are *pulled* by those concerns instead of pushed as narratives. Its documentation already describes that pull as backward chaining and names the capability framework as the operating principle. The alignment isn’t a coincidence — the model and the engine are two instances of the same idea: consumers signal demand, capabilities are discovered at the point of need.

Point the engine at that model and the requirement carries a persona instead of a customer id, and resolution produces persona-tailored views: a senior leader, an architect, and a delivery lead each get their own dashboard of the same capability — maturity panels, evidence-backed prioritization, persona-scoped change feeds, portfolio graphs.

## Anything from anything

The dashboard is a demo, not the point. The same backward-chaining resolution generates HTML sites from models (it has powered my sites for years), scaffolds new projects, and once prototyped a [Tibco BW5](https://bw5.models.nasdanika.org/) engine from process definitions. It builds anything from anything, given providers.

Most of the value in “AI-assisted” software is not the chat. It’s the builder underneath — the part that knows what can be assembled from what. Giving a library of hundreds of widgets with thousands of configuration options to a customer will confuse them. So give it to AI and let it can pick the best fit for a given customer concern.
