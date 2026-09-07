Show a Java developer `[1.0,2.0)` and they will tell you, without hesitating and without ever having been taught, that version 1.9.3 is in and version 2.0 is out.
It is the most widely understood piece of formal notation our industry has, after the semicolon.
OSGi took it from mathematics, Maven took it from OSGi, and now three million people read half-open intervals fluently on their way to lunch.

Then the same developer opens Confluence and writes "applies in the EU from August 2026". In a spreadsheet, "rack X32, slot 5".
In a table, a `valid_from` and a `valid_to` column, with a comment above them explaining whether `valid_to` is the last good day or the first bad one.
Four statements of exactly the same shape, in four notations, none of which can be compared with any of the others by anything except a human being reading carefully.

I did not notice this by thinking about it. I noticed it by writing the same class three times.

## The class I kept writing

I have been building a tower of small models, each floor one concern.
On the lifecycle floor there is a `Sojourn`: a record that some element sat in some stage from one date to another.
In the geography work there is a `Presence`: a record that something was at some place from one date to another.
In the engagement work there is a `Participation`: a record that somebody was involved in something, in a role, from one date to another.

Three names for one sentence: *this thing occupied that thing for a while*.
When I wrote the third one I left myself a note in the assessment, in the tone you use with someone you do not entirely trust: do not unify these yet, readable names are worth more than a premature abstraction, but if a fourth instance shows up, extract the shape.

The fourth showed up last week, and it was not the one I was watching for.
It was not a rack slot or a shelf mark or a berth.
It was my own next feature request.

I wanted to say that something happened a long long time ago, which is to say before something else that happened a long time ago.
So I started sketching `TimeUnit`, and then `AbstractTimeUnit`, and then `TimeUnitDomain` and `TimeUnitReference` and `EvaluatingTimeUnit` with a comparator on it, which is the catalog pattern I use everywhere and which I could have written in my sleep.
I got about that far before the obvious landed.
That was not a fourth instance of the occupancy shape.
That was the occupancy shape, applied to one axis, about to be built a second time at the most expensive floor in the tower, so that in a year I could explain to somebody why "Long Long Ago" is a `TimeUnit` while "Slot 5" is something else.

There is no answer to that question, because there is no difference.
Time is a dimension. It is the dimension with the best libraries and the worst ergonomics, which is why it feels special, but structurally it sits next to rack units, version numbers, geologic eras, sensitivity levels and floor numbers.
Once you say that out loud, the design stops being about time and starts being about axes, and a lot of other people turn out to have been there first.

## The word was wrong

The first thing the prior art took away from me was the word "unit".
A unit is a scale factor: seconds, metres, years. `java.util.concurrent.TimeUnit` is a scale factor enum.
What I actually wanted was a **reference system**, which ISO 19111 defines as an origin, a direction and a scale, and which ISO 19108 extends to time in a way that answers my question directly.

ISO 19108 has had, since 2002, a `TM_OrdinalReferenceSystem` made of `TM_OrdinalEra`: named, ordered, hierarchically nested eras with no numbers in sight.
That is the geologic timescale, which is the discipline that needed it first.
The Cretaceous is before the Paleogene, the Late Cretaceous is inside the Cretaceous, and no geologist reaches for a timestamp to say either of those things.
It is also, exactly and without modification, "Long Long Ago is before Long Ago".
My cute requirement about fairy tales is a solved standards problem from a field that has been arguing about deep time for two centuries.

The same standard hands over the other thing I needed.
`TM_IndeterminateValue` has four values: `before`, `after`, `now`, `unknown`.
That is how you say "some time before the fall of Troy" without inventing a class for it.
And in the humanities there is PeriodO, a gazetteer where a historical period is not a fact but an *assertion by a named scholar*, published with a citation, because scholars disagree about when the Bronze Age ended.
Genealogists worked this out two centuries before software did: every date carries a source and a confidence, and the family model I built for my aunt already had citation quality ratings in it because GEDCOM has always had them.

So mythical time, fictional time and prehistoric time are not a special feature.
They are an ordinal reference system shipped as a data pack with provenance, which is the same thing as a gazetteer of counties, which is the same thing as a catalog of lifecycle stages.
And "rack X32, slot 5" is not an oddity either: ISO 19111 has a category for it, the *engineering* coordinate reference system, a local frame whose datum is not the earth.
The standard was written for ship decks and factory floors. It fits a data centre without a word changed.

## A box, and a set of boxes

The shape that falls out is not complicated.
An occupancy is a box: at most one range per axis.
Version `[2.0,3.0)`, time `[2026-08,)`, jurisdiction `EU`, rack unit `[U5,U9]`.

Two decisions in there cost more than they look.

The first is what an unmentioned axis means, and the answer has to be **unconstrained, not unknown**.
If a statement mentions only time, it applies everywhere.
OLAP settled this in the nineties with the all-member and the partial key, and every system that fudged it produced queries nobody could read a year later.
It is a one-sentence rule that has to be written down before the first line of code, because it is invisible until it is wrong.

The second is what happens when the shape is not a box, and here I had the instinct to add a third point, or a vertex list, or some small amount of geometry.
The right answer is Guava's answer, which is thirty years of collective wisdom compressed into two class names: `Range`, and then `RangeSet`.
When one interval is not enough you do not build a richer interval, you build a set of them.
Spatial databases have been doing filter-then-refine over bounding boxes for four decades for the same reason: boxes are closed under intersection, boxes are indexable, and everything else is a different metamodel wearing a box costume.
Real geometry stays a WKT string with an engine behind it, which is the same call I already made about ISO 19107, and consistency with my own earlier decisions is worth more to me here than expressive power.

There is a third decision that is free, and it is the bracket. Whether an endpoint is included has to be **stored in the data, not implied by the code**.
If you want evidence, look at bioinformatics, where BED files are zero-based and half-open and GFF files are one-based and inclusive, and where the resulting off-by-one bugs are a running joke with real papers behind them.
Two conventions, both defensible, both invisible in the value, and a generation of scientists checking coordinates by hand.

## What it is actually for

None of this is worth doing for tidiness. It is worth doing because the things it makes computable are currently prose.

A vulnerability's applicability is a version range: the OSV schema says so explicitly, with `introduced` and `fixed` events and half-open semantics.
The entire vulnerability management industry runs on interval containment, and the security models I build should be doing that arithmetic against their own data rather than asking a scanner.
A sales tax rate that varies by jurisdiction and date is a two-dimensional box.
An architecture decision record that applies to the EU deployments after the third quarter of 2027 is a binding with a region on it, which is the difference between a decision you can check for drift and a decision that rots quietly in a wiki.

The one I care about most is newer. An AI agent has an operating envelope: which jurisdictions, which hours, which model versions, which data classifications.
Today that envelope is a paragraph in a system card, written by a human, read by an auditor, enforced by hope.
As a region it is a value. You can intersect it with what the agent actually did, which the telemetry floor already records as spans, which are themselves on time, module version and runtime deployment - agent version 2.0.8 executed at such and such time in a data center in such and such location and jurisdiction with, possibly, working on such and such data with its own jurisdiction and other dimensions.
The question "did this agent ever act outside its envelope" stops being an interview question and becomes a query.

## Where it stops

I have to be honest about the failure mode, because it is the one I am most likely to walk into.
Once you have a dimension class, everything with more than two values starts to look like an axis, and my first rule was blunt: a dimension must be totally ordered, and everything else is a name.
Then I tried to say that Rome and Athens are on a geography axis, which they obviously are, and the rule broke in my hands.

What actually needs order is the bracket, not the axis.
`[Rome, Athens)` means nothing; `[2000, 2005)` means something; so a range needs a comparator.
But a nearest-neighbour question needs a distance, and places have one without having any order at all.
A rollup needs a hierarchy, and a hierarchy is not a property of the axis; it is relationships between the things on it, each with a kind and each with its own dates.
Strasbourg is part of Germany from 1871, part of France from 1918, and the two hierarchies of 1942, the one on paper and the one on the ground, are two sets of relationships rather than a contradiction.
Order, distance and hierarchy turn out to be three independent capabilities a dimension may or may not have, and the honest rule is that each one buys exactly one kind of question.
A lifecycle still has none of them in the useful sense: there is no interval between *in review* and *deployed*, and there is no distance either.
The standards were ahead of me again: ISO 19112 exists precisely to say that identifying a location by name and identifying it by coordinate are two legitimate mechanisms, neither of which reduces to the other.

So the model supports both, on the same object, which is the part I think is right and the part I expect to have to defend.
A presence has a place *and* it may have coordinates.
An occupancy has a referent *and* a box.
And "before" on an axis is either computed from values or asserted as a relationship between two named positions, which is how a myth gets a chronology without a single date in it.

Which brings the bracket home.
Maven has called them coordinates for twenty years, and it was right in a way it did not mean.
Each artifact is an axis; a version is a coordinate on it; a declared dependency is a range on somebody else's axis; the set of them is a region, the space you promised to work in; and a resolved build is a point.
"This release runs on Java 21 and Ecore 2.42" is an occupancy, and a point outside its region is a conflict you can see before the build tells you.
Because every version also has a release date, every version axis comes with a calendar behind it, and the distance from the point you are at to the point you could be at, in versions and in years, has a name in the literature, technical lag, and a unit you can add up.
Add it up by module, by owner, by team, and technical debt stops being a feeling and becomes a balance that grows while nobody touches it.

We taught an entire industry to read `[1.0,2.0)`, and then used it for nothing but jar files.
The notation was never about jars.
It was about saying, precisely and comparably, which slice of something a statement covers.
Almost everything a model says is true over a slice of something, and almost none of it says so.
