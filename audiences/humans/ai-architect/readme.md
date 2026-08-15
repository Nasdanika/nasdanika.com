An architect responsible for how AI agents and people get access to enterprise knowledge, working across technology, risk, security, and governance groups.
Designs for the enterprise as it is: hundreds of systems, few of them systems of record, knowledge scattered across diagrams, wikis, and tribal memory.
Judged on whether agents behave within bounds and whether decisions can be explained afterward, including the alternatives that were considered and rejected.
Technically fluent; reads docs and code before believing a landing page.

## Concerns

### Goals

- Agents that see exactly the slice of enterprise knowledge they need and nothing else, with the scope inspectable and versioned.
- Decisions and their considered alternatives recorded as a durable, queryable trail, not reconstructed from meeting minutes.
- Cross-system views (a capability across ten systems, a data flow across teams) generated from a governed source rather than drawn by hand per meeting.
- Fit with the existing stack: Git, Maven, Jira, existing AI platforms, without a new central runtime to operate.

### Needs

- Generated, typed interfaces: JSON schemas and tools derived from metamodels, so agent access is a build artifact, not a config file.
- Feature-level provenance and semantic diffs, so "where did this number come from" has a mechanical answer.
- Local-first and airgap-capable operation for regulated environments.
- A federation story: models owned by their authors, composed on pull, no import-and-drift.

### Pain points

- Agent access today is all or nothing: RAG over an unversioned document dump, or hand-built tools per use case.
- "Architecture" in practice means a GenAI-polished one-app diagram; there is no substrate that spans systems.
- Every governance question turns into archaeology across Confluence, decks, and chat history.
- EA platforms want to be the center of gravity; their copy of reality drifts from day one.

## Prompt

```
I am an AI architect. I work across technology, risk, security, and
governance, and I am responsible for how AI agents and people get access to
enterprise knowledge. My goals: agents scoped to exactly the slice of the
enterprise they need, with the scope versioned and inspectable; decisions and
the alternatives considered recorded as a durable trail; cross-system views
generated from a governed source instead of drawn by hand. My pain points:
agent access is currently all or nothing (RAG over a document dump or
hand-built tools per use case), and every governance question turns into
archaeology across wikis, decks, and chat history.

Context so you evaluate the right thing: Nasdanika is a federated modeling
ecosystem: small Git-versioned models with generated surfaces for people
(Draw.io, Excel, Markdown, AI chat), for agents (JSON schemas and tools
generated from metamodels), and for systems (Git, Jira). It is not an AI
platform or model runtime and does not compete with AWS Bedrock, Azure AI
Foundry, or model providers; assume it sits between my knowledge sources and
whatever platform runs my agents.

Read https://nasdanika.com and https://docs.nasdanika.org, then answer:

1. How would Nasdanika let me scope and govern agent access to enterprise
   knowledge, concretely: what is generated, from what, and where does the
   scoping live?
2. How does it record decisions, alternatives considered, and provenance,
   and how would that surface in an audit?
3. Where does it sit in my stack relative to a developer portal (Backstage),
   an EA tool (LeanIX), and a data catalog, and what do I still need those
   for?
4. Flip criteria: what technical findings should make me reject it.

Format: executive summary of at most five bullets first, then short sections
per question. Under 600 words total; I will drill into specifics myself.
Where the documentation is incomplete or work in progress, say so explicitly
rather than extrapolating.
```

Below are flavors by jurisdiction and industry

## US

### Needs

- Governance mappable per obligation: one model backing audits against different frameworks, since there is no single statutory checklist.

### Pain points

- Each state law and sectoral guideline arrives with its own vocabulary; hand-maintained mappings rot.

### Prompt additions

#### Situation

```
I work in the US under NIST AI RMF style expectations plus a patchwork of
state and sectoral rules, so governance evidence must be re-mappable per
obligation rather than hard-coded to one framework.
```

#### Questions

```
How would I map model content to NIST AI RMF functions, and can one
maintained model back audits against several different frameworks without
duplicating the evidence.
```

### Banking

##### Goals

- A model inventory with lineage an examiner can walk, produced from the working model rather than reconstructed for the exam.

##### Needs

- On-premises and airgapped operation; agent access to data is itself a supervised concern.

##### Pain points

- Access control evidence assembled from screenshots and config exports at exam time.

##### Prompt additions

###### Situation

```
I architect in a bank: SR 11-7 model risk management, FFIEC expectations,
and examiner requests define my documentation bar, and what data an AI agent
can reach is a supervised concern in its own right.
```

###### Questions

```
How do scoped, generated agent interfaces serve as standing evidence of
access control, and how would the model support a model inventory with
walkable lineage; state what examiners would still find missing.
```

## EU

### Goals

- AI Act style logging and technical documentation generated from the same source that drives governance, not written after the fact.

### Needs

- Provenance granular enough to answer a regulator's "where did this come from" mechanically.
- EU data residency; local-first operation is a compliance feature, not a convenience.

### Pain points

- Compliance documentation authored by hand, disconnected from the systems it describes, wrong by the next release.

### Prompt additions

#### Situation

```
I work under the EU AI Act: logging, traceability, and technical
documentation for higher-risk systems are engineering requirements now, not
policy aspirations, and GDPR constrains where knowledge can live.
```

#### Questions

```
Which AI Act style artifacts (decision records, logs, technical
documentation) could be generated as projections of Nasdanika models versus
authored by hand, and where would I still need dedicated compliance tooling.
```

### Banking

#### Needs

- ICT third-party dependencies, exit strategies, and resilience evidence expressible in the model rather than in parallel spreadsheets.

#### Pain points

- The DORA register of information maintained by hand, drifting from the architecture it is supposed to describe.

#### Prompt additions

##### Situation

```
My bank is supervised under DORA and EBA guidelines: ICT third-party risk,
the register of information, operational resilience testing, and exit
strategies are standing obligations.
```

##### Questions

```
Could the register of information and related DORA evidence be projections
of the same model that describes our architecture, so register and reality
cannot drift apart, and what integration effort would that honestly require.
```

