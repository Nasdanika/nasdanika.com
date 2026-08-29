*AI literacy has a prerequisite. It is not listed in the catalog.*

College catalogs contain a diagram every student learns to read before they learn anything else: the prerequisite chart.
Chutes and ladders.
You cannot take Compilers before Data Structures; you cannot take Data Structures before Discrete Math.
Nobody finds this controversial, because everyone has watched what happens to the student who talks their way into the advanced course without the prerequisite: they do not learn the advanced material, they drown in vocabulary.

Corporate AI literacy programs enroll everyone in the advanced course.

AI literacy became a legal obligation in February 2025, when the EU AI Act's Article 4 came into force, and I have argued in the two previous stories in this arc that most of what the obligation actually demands is not about AI at all.
Working through an [AI governance certification course](https://www.udemy.com/course/aigp-cert) made the proportions concrete: my estimate stands at ninety percent.
Ownership, lifecycle, documentation, risk, decision records, oversight, incident response - the certification that makes you an AI governance professional is mostly an examination in how enterprises work.

That ninety percent deserves its own name and its own place in the prerequisite chart.
I will call it **enterprise literacy**: the ability to read and reason about how an enterprise actually operates - who owns what, who may see and do what, what stage things are in, what things cost, how decisions were made and what alternatives lost, what rules apply and what evidence shows they are followed, what work is in flight, how the pieces fit, and what can go wrong.
If those clauses sound familiar, they should: they are the floors of the [Nasdanika Model Tower](https://nasdanika.com/models.html) - role, IAM, lifecycle, accounting, decision, governance, work, architecture, threat.
The tower turned out to be a curriculum.
I did not plan it as one.

I am not a lawyer and none of this is legal advice; as before, this is an engineer reading requirements and asking what would have to be true for them to be satisfiable.

-----

[TOC levels=6]

## The receipt: learning a domain by modeling it

I recently published the [CISO model](https://ciso.models.nasdanika.org/).
Here is the embarrassing part, which is also the point: when I started, I knew little about the CISO problem domain.
I am an engineer and an architect; running a security program - awareness campaigns, continuity exercises, third-party risk, security metrics, the incident-to-threat feedback loop - was a domain I had adjacent vocabulary for and no map of.

So I built the map, with the help of AI and determenistic generation - I'll explain it in a different story.
It took an hour or so of my time. 
Public bodies of knowledge - the CISSP domains, NIST CSF, ISO 27001's control catalog - state what the domain's concepts are.
AI generated a model (Xcore), [Nasdanika CLI](https://docs.nasdanika.org/nsd-cli/index.html) in a GitHub Action generated a documentation site published to GitHub Pages with a Draw.io diagram as part of it.
I reviewed the generated model and then laid out the generated diagram. 
Doin this was a learning activity - understanding how the concepts relate: an incident *realizes* a threat, which is how a security program measures whether its threat model meets reality; an accepted vulnerability *requires a waiver*, which is how risk acceptance stops being a shrug and becomes a governed record.
By the time I finished with the diagram layout, I had an orientation in the domain that weeks of reading had not produced - because a book states concepts in a line, and modeling forces you to state them as a graph, and the graph is the understanding.

Then the compression works in the other direction.
A reader who opens the generated site gets, in one look at the diagram, the skeleton it took me the whole exercise to build - what the concepts are and how they hang together - and can then descend into any one of them, one page, one concept, neighbors linked.

This is not a property of the CISO model.
It is a property of every model in the tower, and it is common enough and valuable enough that it is now [spelled out on the models page](https://nasdanika.com/models.html): every model is a course.

## How a model teaches

Six mechanisms, compounding.

### The map

A generated model site leads with the diagram - the domain's concepts and their typed relationships in one view.
In education research this is a concept map, and concept maps are one of the better-evidenced instructional tools we have: the classic Nesbit and Adesope meta-analysis ([RER, 2006](https://journals.sagepub.com/doi/10.3102/00346543076003413)) and the more recent Schroeder et al. meta-analysis of 142 studies ([Educational Psychology Review, 2018](https://link.springer.com/article/10.1007/s10648-017-9403-9)) both find significant learning gains over studying the same content as text.
The whole "advance organizer" tradition says the same thing older: give the learner the structure first, and the details have somewhere to land.

### The bite

Each element is one page: a single concept, its documentation, its neighbors.
Learning proceeds one concept at a time - but unlike the "microlearning" the training industry sells, the bite is *typed*: the page knows what the concept extends, what refers to it, and what it requires.
Bite-size without structure is a snack; bite-size with typed links is a course.

### The ladder

The tower supplies the prerequisite chart.
The CISO model's Vulnerability leans on the governance floor's Waiver; governance leans on decision; decision leans on lifecycle and IAM.
You do not need to master the lower floors to read the upper ones - but when a definition rests on one, it is one click down, not one degree away.
This is exactly the chutes-and-ladders diagram from the college catalog, generated instead of drawn, and enforced by inheritance instead of a registrar.

### The construction

Here is the finding that turns adoption into pedagogy: the 2018 meta-analysis distinguishes *studying* concept maps (g = 0.43) from *constructing* them (g = 0.72).
Building the map teaches substantially more than reading it - which matches my CISO experience exactly, and which means the customization step is not an implementation cost paid after the learning.
It *is* the learning.
An organization that tailors a model - extends its classes with their cases, loads their frameworks as catalogs, anchors their systems to its elements - is constructing its own map, and comes out the other side understanding its own enterprise in a way no purchased training produces.

### The micro-wiki

Documentation in these models is not a string on an element; it is a space anchored at one - any element, down to a single attribute, can carry pages.
So the org's customized model becomes the place where *their* people, *their* policies, *their* tools are linked from the typed elements they belong to: the AwarenessCampaign element links the actual campaign owner and the actual training platform; the Waiver element links the actual approval workflow.
The model supplies the generated, typed site map that wikis famously lack; the pages supply the depth that models famously lack.
The course graduates into the org's own reference.

### The motion

Diagrams do not have to sit still.
Draw.io - the tool a large share of enterprise diagrams already live in - has interactive machinery built in: click a button and an animation plays, show and hide layers and tagged aspects, walk a reader through a picture step by step.
Few people use it, because the machinery is documented across an editor wizard, help pages, and blog posts - and the [Draw.io model](https://drawio.models.nasdanika.org/) now gives it what those cannot: one class diagram of custom links, actions, and animations, typed and connected.
There is a small joke with a serious payload here: people who use Draw.io are visual people by definition, and the feature built for them was explained to them in prose.
A class diagram of the animation vocabulary - Show, Hide, FadeIn, Highlight, Flow, Wait, targets selected by layers and tags rather than string IDs - is the literacy argument applied to the tool itself.

It also opens what I think of as the *hybrid model*: a manually authored diagram - the picture a human laid out and trusts - with animations *generated* onto it.
Generated from real data: the accounting ledger, telemetry, an explicitly recorded execution.
Or from simulations: a process or an agentic run.
And because actions are typed data, an animation does not have to live inside the diagram file at all - it can be maintained in a Groovy DSL or an Excel sheet, owned by someone other than the diagram's author, with one diagram carrying many animations for many audiences.
My immediate case is explaining how architecture components interact - systems on the system diagram, then containers, then components.
Numbers are good; animation is better.
The honesty clause, as always: the model is published and usable today; the animation-building tooling on top of it is future functionality, to be built on first use.

## What the alternatives cost

Enterprise literacy is currently taught, where it is taught at all, by a set of incumbents with very different price tags.
The figures below are order-of-magnitude context, with vintages stated, because this genre of statistic is routinely abused.

**Tribal knowledge** is the real incumbent - the Excel of this space.
Its cost is invisible and paid in time: Panopto's 2018 study put knowledge workers at 5.3 hours a week waiting for information or recreating work that already exists, new hires at up to six months to full productivity, and the cost of inefficient knowledge sharing at roughly [$47 million per year for a large enterprise](https://www.panopto.com/company/news/inefficient-knowledge-sharing-costs-large-businesses-47-million-per-year/).
The widely cited McKinsey figure of 1.8 hours per day gathering information dates to 2012; treat all of these as vendor-flavored and dated, but the direction is not in dispute - the map lives in heads, and extracting it retail is expensive.

**Courses and certifications** teach well and cost accordingly: instructor-led security courses run to $8-9 thousand per person, certification prep bundles $2-9 thousand plus exam fees, and the average US organization spends [$874 per learner per year on training](https://trainingmag.com/2025-training-industry-report/) against a national total above $100 billion.
The concession is real: courses convey judgment and pass exams; a model does neither.
But course knowledge arrives unlinked to your enterprise, and decays accordingly.
The model is where course vocabulary lands and becomes queryable - study companion, not substitute teacher.

**Analyst subscriptions** run to tens of thousands of dollars per seat per year and deliver something a model cannot: market judgment, peer comparison, someone to call.
What they do not deliver is a typed, customizable, inheritable map of the domain that you own.

**Enterprise architecture tools** are the closest commercial neighbor - they do hold a typed map.
By the vendors' own accounting, that map costs [$50-200K per year for a mid-size deployment and $250-750K for a large one](https://www.ardoq.com/blog/enterprise-architecture-cost-in-2025), covers the application estate rather than the enterprise's operating concerns, lives in a proprietary store behind seat licenses, and inherits nothing - no IAM floor, no lifecycle, no decision records, no provenance.
The tower's map is generated documentation: open, versioned, free to read, free to fork.

**Wikis and developer portals** are cheap on day one and structureless forever after; Backstage's TechDocs gets documentation to the entity level and stops.
The micro-wiki approach takes the wiki's strength - depth, ease of contribution - and gives it the generated site map it never had.

The pattern across the landscape: everything that provides structure is expensive and closed; everything that is cheap and open provides no structure.
A generated model site is the empty quadrant - structure, open, license cost zero.
The costs that remain are attention and customization hours, and the research above says the customization hours are the best-spent learning hours in the whole table.

## What a model cannot teach

The bounded claim, stated plainly.
A model is not a teacher.
Reading the CISO model makes no one a CISO, the way reading a syllabus makes no one a graduate.
Models do not convey judgment, war stories, or the feel for which control fails first under pressure; courses, mentors, and incidents teach those.
What a model delivers is orientation speed, shared vocabulary, and a scaffold that becomes the organization's own - the prerequisite course, not the degree.
Prerequisites are humble and non-optional, which is the point of the chart.

## The course keeps a transcript

One more mechanism, and it closes the loop.
The tower's pull stack - capability, product management, org design - treats people as capability providers: a person provides capabilities, and a capability claim is not a static attribute on a profile but a dated assessment with evidence attached.
Taking the course is evidence.
So is passing the certification, and so is shipping the work that exercised the skill.
Each lands on the person's capability record the way a transaction lands on an account - dated, attributed, kept.

Which makes a resume exactly what a glossary was in the first story of this arc: a view.
Generate it from the capability model on demand, tailored to the audience - and never treat it as the source of truth, because a resume treated as the source is how organizations end up knowing what people claimed rather than what they evidenced.
Public skills frameworks - SFIA, ESCO, O*NET - are bodies of knowledge like any other and load as catalogs, so capability claims can be stated in a shared vocabulary rather than invented adjectives; badge and verifiable-credential standards slot in as the portable evidence artifacts that land on the record, not as competitors to it.

The mechanics are deliberately humble, and that is a feature: capability records are files in a version-controlled repository - reviewable, diffable, signable - with a thin UI or a learning-system integration on top for whoever wants one.
No talent platform required to start.
The grassroots case is a single person keeping their own capability model in a repository and generating their CV from it; the enterprise case is the same files at scale.
One caution belongs in the design, not the fine print: who-can-do-what is among the most access-sensitive data in the tower, which is why it sits above the IAM floor - who may see whose evidence is a first-class, typed question, not a policy PDF.

## Back to Article 4

The regulatory hook from the previous story sharpens here.
Article 4 does not say "train everyone on AI"; it says literacy measures must account for staff's knowledge, experience, and the context the AI systems are used in.
You cannot tailor AI literacy to a context nobody can state.
Describing the context *is* enterprise literacy: who owns this system, what lifecycle stage it is in, what decisions put it there, what rules govern it, what can go wrong.
An organization whose enterprise knowledge lives in tribal memory and slide decks cannot meet a tailoring requirement, because tailoring requires a map of what people already know and where they stand - and there is no map.
The transcript closes this loop: management-system standards have required documented evidence of competence for decades (the harmonized clause 7.2 that ISO 9001, 27001, and now 42001 share), and a capability model where courses and certifications land as dated evidence is that record in queryable form - the same models that teach the material also keep the proof that it was learned.
The prerequisite chart is not pedagogical advice.
It is the satisfiability condition of the regulation.

## The expensive part was always the map

Every incumbent in the landscape above is, one way or another, selling a map of how enterprises work: the analyst sells you theirs annually, the EA vendor rents you an empty one, the course draws one on a whiteboard and erases it at five o'clock, and tribal knowledge makes you excavate it one conversation at a time.
The maps in the tower are free, generated, typed, and built to be taken and made yours - and making one yours is, by the best evidence we have, the most effective way to learn what it maps.

Take the course.
Then teach it to your organization by customizing it - that is the one pedagogy where the student ends up owning the school.

*Models at [nasdanika.com/models.html](https://nasdanika.com/models.html). The CISO model, this story's receipt, is at [ciso.models.nasdanika.org](https://ciso.models.nasdanika.org/).*
