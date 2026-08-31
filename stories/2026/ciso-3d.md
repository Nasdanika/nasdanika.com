*Under an hour of my time. The tower was the printer.*

I recently published a [model of the CISO problem domain](https://ciso.models.nasdanika.org/) - incidents, vulnerabilities, awareness, continuity, third parties, metrics.

I did not need it.

I am not a CISO and nobody asked me for it.
It was adjacent to work I was already doing - the [governance](https://governance.models.nasdanika.org/) and AI governance models - and I am taking an [AIGP preparation course](https://www.udemy.com/course/aigp-cert), so I wanted a general idea of the domain next door.
A few years ago, "I wanted a general idea" would not have justified building and publishing a typed model with a documentation site.
Now it does, and that change in the justification threshold is what this story is about.

When fabrication is expensive, you build only what you must.
When you have a printer and filament, you print things because they are useful-adjacent - a bracket, a stand, a part for a machine you are merely curious about.
The marginal cost has collapsed, so the decision changes character: not *can I afford to build this* but *is there any reason not to*.

The printer, in my case, is the [model tower](https://nasdanika.com/models.html) plus a toolchain: AI, the [Xcore archetype generator](https://github.com/Nasdanika-Archetypes/xcore-model), the Xcore documentation generator, GitHub Pages.
The filament is a dozen floors of already-built machinery - roles, access control, lifecycles, decisions, governance, work, architecture, threats.
The CISO model is a printed part that snaps onto that assembly: about ten classes and six enumerations of its own, everything else inherited.
And like most 3D prints, it is honestly a prototype - printed fast, refined on first use.
That is not an apology.
Prototypes you can afford to print are how you find out what the final part should be.

## The print log

Here is the whole build, with times.
The point of the itemization is that every line is boring - and that the total is under an hour of my time.

| Step | My time | Notes |
|---|---|---|
| Write the generation prompt | ~5 min | I had a template from previous models; prompt shared below |
| AI generates the Xcore model | ~0 (minutes of AI thinking) | ~200 lines of Xcore; a few dollars of tokens if not on a subscription |
| Generate a starter project | <5 min | Create GitHub repo, clone, run the archetype generator |
| Copy Xcore in, adjust pom.xml and module-info.java, review and tweak | <10 min | The only step resembling engineering |
| Copy, review and edit the readme | ~10 min | Also not a chore - see below |
| Push, configure GitHub Pages, optional DNS record | ~5 min | |
| Download the generated Draw.io diagram, lay it out | <5 min | Not a chore - see below |
| Push again - site with a diagram is live | ~0 | |
| Submit the sitemap to Google | ~2 min | |

### Xcore generation prompt

```
Read the Nasdanika Model Tower (https://nasdanika.com/models.html) and
generate a CISO problem domain Xcore model in models/ciso: ciso.xcore plus a README.md writeup.
Position the model in the tower. 

The README should follow the pattern of the other models in the tower.
```

Two numbers in that log deserve a pause.

The generated artifact is about **200 lines of Xcore, and none of it is executable code**.
Compare that to the now-fashionable alternative: generating a hundred thousand lines of executable code, possibly in a language that is not the team's primary one.
Two hundred declarative lines are cheap in every currency that matters - tokens, review time, risk, maintenance.
A model this small can be *actually read* by the person accountable for it, which is a property almost nothing generated at scale has.

And the model is small **because the tower ate most of it**.
A large share of the concepts were already provided by lower floors - status workflows are the lifecycle model, ownership is the role model, risk acceptance is a governance waiver, cost is accounting.
They got [tetrised](https://nasdanika.com/stories/2026/model-tetris.html) down, and what remained is only what a running security program adds.
The floors are why the print is fast; the print is small because the filament is structured.

## Laying out the diagram is the lesson

One line in the log looks like a chore and is the opposite: laying out the generated Draw.io diagram.

To place the classes you have to decide what is central and what is peripheral, what clusters with what, which references deserve to cross the page and which should be short.
You cannot do that without holding the domain in your head, and by the time the layout looks right, you do.
As the proverb goes: I do and I understand.
Whit is what I do - my diagram generator has a very simple layout algorithm. I'll change it to [ELK](https://elk.models.nasdanika.org/) in the future. 
I first auto-layout it using vertical or horizontal layout - it has no respect to inheritance direction and is not perfect in general, but it is good enough to grasp 
the model structure. 
For some models I just leave it as it is - [Maven](https://maven.models.nasdanika.org/) for example - it is huge because it was generated from the POM XML Schema. 
For other models I manually lay out the diagram.
Sometimes I subset a diagram - just core classes and relationships.

Editing the generated readme is the second pass of the same thing - kinesthetic learning at a keyboard.
The diagram gave me the skeleton; arguing with the readme's prose gave me the depth.

There is an old teachers' joke about this.
A teacher complains to a colleague: "What a dull class they gave me!
I explain the theorem - they don't get it.
I explain it a second time - they don't get it.
The third time I explain it, I finally understand it myself - and they still don't!"
Every explainer knows this is not really a joke.
The one doing the explaining is the one doing the learning, and editing a readme that explains a domain to others is the third explanation.
The class's outcomes are not guaranteed.
The teacher's are.

This is the [Enterprise Literacy](https://nasdanika.com/stories/2026/enterprise-literacy.html) argument made personal.
The research finding there was that *constructing* a concept map teaches substantially more than studying one.
The print log is what constructing looks like when the tower does the heavy lifting: under an hour, most of it spent exactly where the learning is.

Also worth saying plainly: this was **cheaper than taking a course** - in money and in time (an hour against days)
With the same bound as before: cheaper *for the orientation layer*.
A course conveys judgment and war stories; the print conveys structure.
I still take courses.
Now I have somewhere to hang them.

## What I got besides the knowledge

Here is what a course would not have left behind: **an instrument**.

I have a picture I can use to explain the domain to others, or to check my own understanding against someone who knows it better - point at the diagram and ask "is this how it works?"
A wrong reference on a diagram gets corrected in seconds; a wrong paragraph of prose can survive review forever.

The picture also works on AI, in both directions.
I can ask an assistant to explain a concept *grounded in the model* - my model, with my organization's structure - instead of grounded in the averaged industry prose it was trained on.
And when I forget - I will - the model remembers.
An externalized, typed memory of a domain I visited once is a different asset from a stack of course notes I will never reopen.

## The micro-wiki move, ten minutes in

The [micro-wikis](https://nasdanika.com/stories/2026/micro-wikis.html) pattern - every model element anchors its own documentation space - has a property that only becomes obvious when you try it: **the generated documentation stubs tell the AI which files to edit**.

A real example.
I cloned my [agent model](https://agent.models.nasdanika.org/), downloaded the documentation stubs, and asked an AI coding assistant to read an organization's information-security guidelines and AI policies and match them to model elements - edit the stub for each element with the paragraphs and processes that govern it.
Under ten minutes later I had a published site where clicking a Java tool shows exactly which policy paragraphs apply to it, and clicking an MCP tool shows a visibly heavier review-and-approval path.

That last click is worth a story of its own, because many people conflate MCP servers with agent tools, and the difference is not academic.
An in-process tool is a trip to your own pantry.
An MCP server is driving to another country for groceries: there is a border, the border has guards, you will show your passport, and you will declare your produce and it might be illegal to bring produce and other food items across the boreder.
The guards are also not infallible: an AI gateway in production can read a nine-digit number as a Social Security number and any sixteen-digit number as a payment card.
Sometimes the border is exactly what you want - that is what borders are for.
But you should know you are crossing one before you get in the car, and a model where the two kinds of tool are different types with different governance attached makes the border visible at the point where someone is about to propose the trip.

## Duolingo for the security tribe

There is one more reason to print a model of a domain that is not yours: **language**.

When I travel internationally I spend some evenings on Duolingo first - not to become fluent, but out of respect, and because ordering coffee in the local language changes the interaction.
Modeling a group's domain is the same move with a better payoff.
Security has a language: assets, findings, waivers, exercises, tabletops, KEV, RTO.
Walk into a meeting speaking it - with a heavy accent, no doubt - and the meeting is different: you are understood, corrections are cheap, and the whiteboard fills with references to a shared picture instead of two groups speaking two different internal DSLs based on English.

An hour of printing against a recurring translation tax on every future meeting.
That trade is not close.

## A tribute, and a warning about standard tools

At home I use [FAR Manager](https://www.farmanager.com/), Eugene Roshal's orthodox file manager, and with it I am several times faster at file work than with anything available on a standard enterprise desktop.
Two panels; copy and move between them; walk into archives and remote sites as if they were folders; edit with highlighting, right there.
Midnight Commander is close, but it lives on Linux and I live on Windows.
At work, without it, I spend brain cycles *thinking about file operations* - cycles FAR made free decades ago - and then I spend more cycles executing them.

Tool standardization is important and I am not arguing against it.
I am arguing that it has a cost, the cost is paid in attention, and attention never appears on the invoice.

## Print your own

The bounded claim, as always: printing this model did not make me a CISO.
It made me *literate* in CISO - oriented, conversant, and equipped with an instrument that keeps paying: a picture for meetings, a grounding for AI, a scaffold the [readme](https://ciso.models.nasdanika.org/) now builds on with the awareness economics, the capability evidence, and the landscape.

The prompt are above.
The [archetype generator](https://github.com/Nasdanika-Archetypes/xcore-model) is public.
The tower is free.
The next time a domain is merely adjacent to what you do - print it.
The justification threshold is not what it used to be.

*The general argument - why every model is a course, what the alternatives cost, and what the research says - is in [Enterprise Literacy](https://nasdanika.com/stories/2026/enterprise-literacy.html).*
