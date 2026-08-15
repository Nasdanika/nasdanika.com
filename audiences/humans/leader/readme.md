A senior leader (director, VP, or head of function) accountable for AI adoption, AI literacy, and developer experience across an organization.
Owns outcomes and audit posture, not implementation.
Evaluates technology by organizational consequences: adoption cost, risk, regulatory readiness, and whether the people who have to live with it will accept it.
Has seen platform migrations sold as transformations and is skeptical of anything that requires the whole organization to move at once.

### Concerns

#### Goals

- AI adoption that is credible to auditors, regulators, and the board, not just demo-ready.
- Decisions grounded in current reality rather than in hand-assembled decks and stale snapshots.
- A record of what was decided, from what inputs, by whom, ahead of regulation such as the EU AI Act rather than behind it.
- Developer experience improvements that do not create another platform team and another migration.

#### Needs

- An honest comparison against the alternatives actually on the table, with explicit walk-away criteria.
- An adoption path that starts with one team and one artifact, shows value in weeks, and can be stopped without writing off a platform investment.
- Provenance: any number or diagram in a review must trace to its source.
- Something that runs where the data is allowed to live, including fully disconnected environments.

#### Pain points

- Quarterly reviews assembled by hand from Jira, ServiceNow, and last quarter's deck; decisions follow whichever narrative arrived first and was packaged best.
- Every tool pushes its own partial view; nobody owns the whole picture.
- Institutional knowledge locked in decks, wikis, spreadsheets, and heads, invisible to both people and AI agents.
- Centralized platforms whose copy of reality starts aging at import time, and whose audit trail ends at "uploaded by".

## Prompt

```
I lead an organization and I am responsible for AI adoption, AI literacy, and
developer experience. My goals: AI adoption that stands up to audit, decisions
grounded in current reality instead of hand-assembled decks, and a record of
what was decided, from what inputs, by whom. My pain points: every tool pushes
its own partial view, reviews are assembled by hand from stale snapshots, and
institutional knowledge is locked in decks, wikis, spreadsheets, and heads
where neither people nor AI agents can reach it.

Context so you evaluate the right thing: Nasdanika is a federated modeling
ecosystem. It keeps enterprise knowledge in small, Git-versioned models that
people reach through Draw.io, Excel, Markdown, and AI chat, agents reach
through generated schemas and tools, and systems reach through Git and Jira.
It is not an AI platform, model runtime, or hosting service, so do not compare
it to AWS Bedrock, Azure AI Foundry, or model providers; it works alongside
whatever AI platform I already have.

Read https://nasdanika.com and https://docs.nasdanika.org, then answer:

1. What does Nasdanika address for someone in my position that the adjacent
   categories do not: developer portals (Backstage), EA tools (LeanIX),
   wikis and document stores (Confluence, SharePoint), data catalogs?
2. A realistic adoption path: first team, first artifact, first month, and
   what I should expect to see before committing further.
3. Selection criteria I should apply, and the walk-away criteria: what
   findings should make me drop it.

Format: start with an executive summary of at most five bullet points, then
brief sections for the three questions. Keep the whole answer under 500 words;
I will ask for depth where I want it. Where the documentation is incomplete or
silent, say so plainly instead of guessing; parts of it are explicitly work in
progress.
```

Below are flavors by jurisdiction and industry

## US

### Goals

- Defensible AI governance without a single statutory checklist to point at.

### Pain points

- A patchwork of state laws and sectoral guidance; every audit measures against a different yardstick.

### Prompt additions

#### Situation

```
I operate in the US, where there is no single federal AI law: I face a
patchwork of state laws and sectoral guidance, with NIST AI RMF as the
de facto yardstick for whether our governance is defensible.
```

#### Questions

```
How would one governed model support NIST AI RMF style governance and serve
audits against multiple, shifting state and sector requirements, and what
governance work remains manual.
```

### Banking

#### Goals

- Pass examinations without a documentation fire drill.

#### Needs

- Lineage an examiner can follow from a reported figure back to its source, without moving data outside the bank's boundary.

#### Pain points

- Model inventories kept in spreadsheets; every exam a scramble to reconstruct decisions and change history.

#### Prompt additions

##### Situation

```
I lead in a bank. Model risk management guidance (SR 11-7, OCC 2011-12) and
examiner expectations apply: models need documented purpose, inputs,
validation, and change history, and AI use is a supervised concern.
```

##### Questions

```
How do feature-level provenance and versioned models map to model risk
management documentation and examiner requests, and which parts of that
documentation would still be authored and maintained by hand.
```

## EU

### Goals

- Demonstrate EU AI Act readiness with generated, current evidence rather than compliance-by-spreadsheet.

### Needs

- Data residency: knowledge and its processing stay within EU boundaries.
- Technical documentation that regenerates as reality changes instead of aging between submissions.

### Pain points

- Vendors stamping "AI Act ready" on everything while shifting the actual record-keeping burden to the customer.
- Compliance documents that are stale the day they are filed.

### Prompt additions

#### Situation

```
I operate in the EU. The EU AI Act applies to us, including record-keeping
and technical documentation obligations for higher-risk systems, and GDPR
constrains where data can live and be processed.
```

#### Questions

```
How would Nasdanika help produce and keep current the records the EU AI Act
expects (what was decided, from what inputs, by whom, plus technical
documentation), and state clearly what compliance work it does not do for me.
```

### Banking

#### Needs

- Runs entirely within the bank's boundary, including disconnected environments; nothing leaves supervision.

#### Pain points

- DORA registers and outsourcing documentation maintained by hand in spreadsheets, aging between submissions.

#### Prompt additions

##### Situation

```
I lead in a bank supervised under the EU framework: DORA applies, including
ICT third-party risk and the register of information, alongside EBA
outsourcing guidelines and ECB supervision.
```

##### Questions

```
Could DORA-style evidence (register of information, ICT third-party
dependencies, operational-resilience documentation) be maintained as
projections of a living model rather than hand-kept spreadsheets, and what
does Nasdanika not address there.
```

