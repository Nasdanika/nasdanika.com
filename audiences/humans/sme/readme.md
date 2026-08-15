
A domain expert whose knowledge the organization depends on: a payments specialist, a mainframe veteran, an actuary, a compliance officer.
Years of understanding live in decks, spreadsheets, diagrams, and their head.
Not a developer and not interested in becoming one; fluent in Excel, PowerPoint, Draw.io or Visio, and email.
Repeatedly asked to "share knowledge" by tools that demand re-authoring into someone else's structure, after which the content is orphaned, uncredited, and stale.
Protective of ownership, and rightly so.

## Concerns

### Goals

- Knowledge captured once, in a form that stays current and keeps paying off, instead of being re-explained in every meeting and re-slided for every audience.
- Visible, durable credit: the knowledge stays attributed to its author.
- Usefulness to others, including AI agents, without the author becoming a help desk.

### Needs

- To keep authoring in the tools already mastered: Excel, Draw.io, Markdown, documents. No new authoring environment, no learning a modeling tool.
- Ownership that survives capture: the artifact lives where the author keeps it, versioned, with changes attributed at the level of the thing that changed.
- A gentle first step: one spreadsheet or one diagram, not a knowledge-management program.

### Pain points

- Explaining the same thing for the tenth time because the last nine explanations died in decks.
- Knowledge extracted into wikis and platforms where it decays, gets edited by strangers, and loses attribution.
- Being invisible to the AI wave: agents answer questions in the SME's domain from stale or wrong sources while the real knowledge sits unreachable.
- "Knowledge capture" initiatives that mean weeks of re-authoring into a tool that will be replaced in two years.

### Prompt

```
I am a subject-matter expert. Years of my knowledge live in decks,
spreadsheets, diagrams, and my head. My goals: capture it once so it stays
current and credited to me, instead of re-explaining it in every meeting; make
it usable by colleagues and AI agents without me becoming a help desk. My pain
points: knowledge-capture tools that demand weeks of re-authoring into
someone else's structure, wikis where my content decays and loses attribution,
and AI agents that answer questions in my domain from stale or wrong sources
while my real knowledge sits unreachable. I am not a developer: I work in
Excel, Draw.io, PowerPoint, and documents, and I intend to keep doing so.

Context so you evaluate the right thing: Nasdanika is a federated modeling
ecosystem that captures knowledge in small versioned models while authors
keep working in familiar tools (Draw.io, Excel, Markdown); AI agents and
generated sites read from the same models. It is not an AI platform or
chatbot product, so do not compare it to AI platforms or model providers.

Read https://nasdanika.com and https://docs.nasdanika.org, then answer:

1. Concretely, how would knowledge in my spreadsheets and diagrams be
   captured: what do I keep doing in my tools, and what happens around them?
2. Who owns the result, where does it live, and how is my authorship
   recorded when something changes?
3. What does my first week look like, starting from one spreadsheet or one
   diagram? What effort is required from me, and what do I get back first?
4. What should make me refuse: which promises here would a skeptic check,
   and how?

Format: executive summary of at most five bullets first, then short plain
answers per question, no jargon. Under 450 words; I will ask follow-ups.
Where the documentation does not answer something or is work in progress,
say so instead of guessing.
```

Below are flavors by jurisdiction and industry

## US Banking

### Pain points

- At exam time my old decks and spreadsheets get pulled into evidence; I answer for content I wrote years ago with no record of how it has been reused since.

### Prompt additions

#### Situation

```
I am an expert in a US bank: my domain knowledge ends up in model
documentation and examiner responses, and a wrong AI answer in my area is a
supervised matter, not an inconvenience.
```

#### Questions

```
If an AI agent or an exam response uses my captured knowledge, how does it
trace back to me and to the exact version of my artifact, and how do I
correct an error once, in one place.
```

## EU

### Pain points

- Being asked to sign off on compliance documents assembled from my old decks, with no way to see what changed since.

### Prompt additions

#### Situation

```
I work in the EU, where documentation and traceability obligations
increasingly reach my domain: what I know ends up in regulated documents
that someone has to stand behind.
```

#### Questions

```
When my knowledge feeds regulated documentation, how are my authorship and
each subsequent change recorded, so the record protects me rather than
exposes me.
```

### Banking

#### Pain points

- My spreadsheets quietly feed supervisory registers and resilience reports; when a number is questioned, the trail ends at me with no record of what I actually provided and when.

#### Prompt additions

##### Situation

```
I am an expert in a supervised EU bank: my domain knowledge feeds
documentation that regulators read, and a wrong AI answer in my area is a
compliance incident, not an inconvenience.
```

##### Questions

```
If an AI agent or a regulatory document uses my captured knowledge, how does
it trace back to me and to the exact version of my artifact, and how do I
correct an error once, in one place.
```
