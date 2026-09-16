*Banks once paid seven figures for a list of entity names. Then they went back to Excel. Something is about to ask them for that list again.*

There is a category of software product most people have never heard of, which used to be extraordinarily expensive: the industry data model.

IBM sold one for banking, descended from its Information FrameWork, and another for insurance.
Oracle sells a Financial Services Data Foundation, and siblings for retail, telecoms and utilities.
Teradata had its Financial Services Logical Data Model.
What you bought was content: thousands of entities, their attributes, their relationships, their definitions, blessed by an industry and delivered as a starting point so you would not have to argue about what a Customer is from first principles.
The licences ran into six and seven figures before anybody implemented anything.

I want to be careful about what that proves.
It proves people have paid a great deal of money for structure.
It does not prove they were happy afterwards.

## What happened to that market

It deflated, and the reason is worth sitting with, because it is the same reason the ivory tower team at your bank is ignored.

Those models were enormous.
They served multi-year enterprise data warehouse programmes, the kind with a steering committee and a three-year horizon, and a great many of those programmes were quietly abandoned.
The model was not usually the thing that failed, but it was in the room when the failure happened, and organizations remember proximity.

So the retreat to spreadsheets and wiki pages is not ignorance.
It is scar tissue.
Somebody at that bank remembers a canonical model that arrived as a thousand-page PDF and a database schema, consumed two years, and produced a governance forum.
When you walk in and say "domain model", that is the film playing behind their eyes.

This is the part that took me longest to accept.
I had been treating Excel and Confluence as the competition: primitive tools used by people who had not discovered modeling yet.
They are not the competition.
They are the survivors.

## What changed

Something started asking for the list again, and it is not a steering committee.

Palantir's entire pitch for its AI platform is that the Ontology - their word, capitalised - is what lets a language model act on your business rather than talk about it.
Strip the branding and the claim is unremarkable: an agent that does not know what a Customer is will invent one.
What is remarkable is that the claim is now load-bearing for a company worth a great deal of money, which settles the question of whether anybody wants machine-readable domain semantics in 2026.

They do.
The market did not die, it changed buyer.
It used to be bought by a data warehouse programme.
It is now bought by whoever is responsible for an assistant that must not make things up.

And the seam in Palantir's version is visible from a long way off: the Ontology does not leave.
You can have the structure, and you can have it as long as you keep paying, and you cannot take it with you.

## The landscape, honestly

Five camps, and none of them is Excel, which is why Excel keeps winning.

The **industry model vendors** - IBM, Oracle, Teradata - sell content and carry the scar tissue.
The **standards bodies** - FIBO from the EDM Council, BIAN's service landscape, ISO 20022, ACORD - give away content that is genuinely good and almost unusable, because it ships as OWL files, PDFs and spreadsheets with no tooling around them.
The **data catalogs** - Collibra, Alation, Atlan - govern physical assets well and leave business semantics thin, because a catalog is organised around where data lives rather than what it means.
The **semantic layers** - dbt, Cube, AtScale - have the freshest story and the narrowest scope: analytics, metrics, joins, nothing about ownership or lifecycle or who approved this.
The **ontology platforms** - Palantir above all - have the whole thing and keep it.

The modeling tools, Sparx and erwin and the rest, are not really in this list.
They produce documents.

## The uncomfortable sentence

Here is the thing I have to say about my own work before I say anything else about it.

A metamodel is a vessel.
IBM and Oracle never sold the vessel; they sold what was in it.
Nasdanika has a tower of composable micro-models, a metamodel for describing domain models, generated documentation, federation by URI, and soon a viewer that runs in a browser with nothing uploaded - and not one banking entity in the whole portfolio.

An empty vessel is not a product, however good the vessel is.
Every time I have caught myself excited about the substrate, the honest correction has been the same: nobody buys substrate.

## What that leaves, which is more than it sounds

**Fill the vessel with content you do not have to write.**
FIBO is published under a permissive licence.
BIAN publishes its service landscape.
ISO 20022 publishes a repository.
All of it is free, all of it is credible, and all of it is currently delivered in formats that make it hard to use - which means loading it into a typed model and publishing it as a browsable site and an installable package is a real contribution rather than a demo.
It borrows credibility instead of claiming it, and it costs a loader.

**Sell the deliverable, not the model.**
A consulting engagement is mostly a race to understand an unfamiliar estate, and the artifact at the end is usually a deck that stops being true the week after it ships.
The same engagement that produces a living, queryable, regenerable model produces something the client still has in a year.
That is a better deliverable at the same price, and it needs no content library at all.

**Lead with grounding, not with modeling.**
The word "model" is radioactive in exactly the rooms where the work is most needed.
"Your assistant is confidently wrong about your business because nothing ever told it what a Customer is, and the answer should live in your Git rather than in somebody's platform" is the same sentence with the scar tissue removed.

**Let the spreadsheets be the input.**
This is the one that inverts the old failure.
IBM and Oracle asked you to adopt their model.
The interesting move is to capture yours - from the spreadsheets and the wiki pages and the tracker that already hold it - because then nobody has to agree to a two-year programme before anything is true.

## The risk I cannot argue away

Agents may not need any of this.

Context windows keep growing, and language models keep getting better at inferring structure from raw schemas and a pile of documentation.
It is entirely possible that the winning answer is "paste the DDL and two hundred thousand tokens of Confluence" and that curated ontologies turn out to be a thing that felt necessary for about three years.
I do not think the evidence settles it either way yet, and anybody who tells you otherwise is selling something.

The counter-argument I actually believe is narrower than "agents need ontologies".
It is that **an answer you have to defend needs a declared model**.
If an agent tells a regulator's examiner how customer exposure was calculated, the chain from the answer to the definition to whoever owns the definition has to exist, and it has to have existed before the question was asked.
Inference is not a chain of custody.

That is a smaller market than "all of AI".
It is also, as it happens, the market that was already here: the one that pays for evidence rather than for output.

## What the vessel is actually for

The industry data model was sold as a shortcut past an argument - here is what a Customer is, you may stop debating.
It failed partly because the argument was the valuable part and the model was where the conclusions were supposed to go.

What I think is worth building is not a better shortcut.
It is somewhere for the conclusions to live that a machine can read, that Git can version, that a regulator can follow backwards, and that nobody can take away from you.

Whether anyone pays for that is a separate question from whether it is true, and I would rather find out cheaply than argue about it.
Loading FIBO takes a fortnight and tells you more than a year of positioning.
