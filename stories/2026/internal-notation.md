Open [family.ecore.md](https://github.com/Nasdanika-Templates/markdown-ecore-doc) and you are looking at an ordinary Markdown document.
Headings, some prose under each one, a few bracketed annotations.
GitHub renders it. GitLab renders it. Anyone can read it without being told anything.

It is also an Ecore metamodel, exactly and completely, because of a handful of conventions:

* Level 1 is the package.
* Level 2 is a classifier, `## Family {superTypes="Named Element"}`.
* Level 3 groups features, `### Attributes` and `### References`.
* Level 4 is a feature, `#### Parents {type="Person" multiplicity="0..2" opposite="Children"}`.
* The prose sitting under any heading is that element's documentation, by virtue of sitting there.

No new syntax was invented.
Markdown already had heading levels, nesting, order, and the idea that text under a heading belongs to it.
All that was added is an agreement about what those existing things mean in this particular kind of document.

That agreement is the thing I have been building for years without naming.
I have named the machinery that executes it, [semantic mapping](https://medium.com/nasdanika/semantic-mapping-3ccbef5d6c70), which is the compiler.
I have never named the language the compiler compiles.

## Every surface arrives with expressive means

A format is not a blank sheet. It ships with a set of distinctions its authors can already make and its readers can already see.

Markdown ships heading level, nesting depth, document order, lists ordered and unordered, tables, emphasis, links, code fences, and, through the kramdown and pandoc dialects, attribute lists.

Draw.io, Visio and PowerPoint ship shape identity, containment, connection with direction, stroke color, stroke width, dash pattern, fill, size, position, z-order, grouping, layers, pages, and a slot for arbitrary custom properties.
PowerPoint adds layouts, placeholders, alt text and speaker notes.

These are given. People already know how to produce them, every tool already enforces their well-formedness, every viewer already renders them, and no one has to be trained.
The question an internal notation answers is not "what shall we be able to express" but "what shall the expressive means we already have be taken to mean here".

An internal DSL does not invent syntax.
It overloads the host language's existing constructs, method chaining, blocks, operators, so that ordinary Java or Groovy reads as domain vocabulary.
In other words, it overloads the existing expressive. 

Similarly, an **internal notation** assigns domain meaning to expressive means a format already has.
An **external notation** invents its own expressive means and needs an editor built or generated to produce them.

## Two kinds of carriers, and they behave differently

Looking at my own artifacts, the conventions divide cleanly in two, and I had not separated them.

**Overloaded structure.** Heading level, nesting, order, prose position, containment, connection, arrow direction.
These already mean something to a human reading the document, and the notation makes that reading formal.
A reader who has never heard of the notation still gets most of it right, because a heading below another heading already looks subordinate, and a box inside another box already looks contained.
This is the good kind. It is self-documenting and it survives being read by people who lack the mapper.

**Provided slots.** Kramdown attribute lists, Draw.io custom properties, Visio shape data, PowerPoint alt text and speaker notes.
Formats supply these deliberately as places to put things the format itself does not understand. `{type="Person" multiplicity="0..2"}` is not an overloaded heading, it is a filled slot.
Slots are unambiguous and safe, and they are invisible to the reader, which is the whole tradeoff.

Between the two sits the dangerous middle: **aesthetic carriers**. Stroke color, width, dash.
They are expressive means, they are tempting, and they are shared with taste.
Red may mean deprecated to the mapper and important to the reader, and the first person who tidies the diagram will change it without any sense of having edited a model.
Styles are useful - in UML connection styles define whehter a connection is a composition, aggregation, subclassing or interface realization. 
Storing such information in properties can lead to a situation where somebody changes connection style and forgets to changge properties.
Therefore, the meaning of style shall be documented. 
Some of such meaning is widely understood. For example, in Jira grey means TODO, bulue IN PROGRESS, green DONE. 
Adding a legend and possibly a user library makes the meaning of style clear.

## This pattern is proven, only unnamed across media

I want to be careful not to present a known pattern as a discovery.
Assigning meaning to existing structure is one of the more successful moves in our field.

Javadoc did it to comment structure.
Front matter and attribute lists exist in Markdown dialects because people kept wanting this.

What is missing is not the pattern. It is a name that spans text and pictures, so that "level 1 is an EClass" and "a dashed red connector is a deprecated dependency" are recognizably the same kind of statement, plus the machinery to execute them, which is where my work actually sits.

## Notation and mapping are not the same thing

This is the test of whether the coinage earns anything, so I want it explicit.

The notation is the agreement: what the expressive means are taken to mean.
The mapping is the executable interpretation of that agreement. Grammar and parser.

They come apart in ways that matter. A notation can be published, read, followed and taught with no code in the room, which is how a subject matter expert can author correctly on day one.
Two mappers can implement the same notation, in different languages, against different target metamodels.
A notation outlives the mapper that first executed it, which is the same durability argument I make about plain text and Maven Central.
And a document can be checked for conformance to a notation before anything interprets it, which is a linter.

"Semantic mapping" names the act well and I am not retiring it.
It just cannot answer "what do I hand my colleague so she can draw this correctly", and that artifact needs a noun.

## Why meaning can be assigned later

Because the means belong to the format and not to the notation, a document is complete, valid and readable before anyone decides what it means.
That is the whole of [draw first, execute later](https://medium.com/nasdanika/draw-first-execute-later-iterate-forever-d6ac29d7aba5), stated as a cause rather than a practice.

It also means the assignment can be done by someone other than the author.
A workshop produces a diagram ona a whiteboard.
A photograph of it becomes a Draw.io file, and I have had an AI assistant do that conversion well enough to keep.
Then meaning gets attached, by an architect binding shapes to the notation, or by an agent proposing bindings by matching shape labels against system names and a human confirming.
Four steps, four actors, one of them a whiteboard.
None of that sequence exists if drawing and meaning are the same act, which is the condition an external notation enforces by design.

The same holds in text.
Somebody writes a document about their domain because they wanted a document.
Later it turns out the headings were classifiers all along.

## The cross-surface question

If a notation is an assignment of meaning to a surface's own expressive means, then a notation is surface-bound by definition.
Markdown has no stroke width. Draw.io has no heading level. There is no literal notation that both can carry.

What can be shared is one level up. The semantic target is shared, and so are the abstract distinctions the surfaces make in their different ways: identity, label, containment, connection, direction, order, grouping, emphasis, annotation.
The [Diagram model](https://diagram.models.nasdanika.org/) is already an attempt to name those for the visual family, and the [presentation family design](https://presentation.models.nasdanika.org/) already lifts Draw.io, Visio, PowerPoint, PlantUML and Mermaid into it.

So the honest framing is one semantic model with a family of notations, and the open decision is how much of a notation can be stated abstractly, over those shared distinctions, and merely *bound* to each surface's concrete carriers.
My instinct is that quite a lot can, that the abstract statement is "containment means composition" while the binding says "in Draw.io that is a child cell, in Markdown that is a deeper heading", and that this is what a shippable notation pack would contain.

## The host is already in the training data

One argument that would have been weak ten years ago.
An external notation produces a format nobody has seen, so every model that might help you author in it must be taught first, with examples, forever.
An internal notation inherits its format's presence in the world, and that now includes the training corpus.
Frontier models produce Markdown, mxGraph XML and Mermaid fluently and unprompted.
Assigning meaning to expressive means the machine already produces correctly is a different proposition from teaching it a private syntax.

## Where this is the wrong call

When the domain needs a distinction the surface cannot make, and you find yourself overloading a third aesthetic attribute to encode it, the notation has outgrown its host.

When the audience must be prevented from producing something wrong, because a palette offering only legal moves teaches faster than any convention document and stops the error at the moment of drawing. Safety engineering lives here.

When the overloading collides with what the reader already believes the formatting means, and the document becomes correct for the mapper and misleading for the human.

## The word

I am not certain "internal notation" is right, and the uncertainty is worth stating rather than resolving by usage.

For it: the internal DSL analogy is exact under the corrected reading, the pair with "external notation" is what makes it usable, and it covers text and pictures with one word, which is the gap.

Against it: "notation" already has a precise and different job in the modeling world, where it means concrete syntax, and a reader from that tradition will hear a synonym rather than a distinction.
"Profile" is the term that community already uses for meaning added inside an existing notation, and "a Draw.io profile for architecture models" is immediately legible, at the cost of borrowing vocabulary from the Eclipse and OMG world I have deliberately walked away from.
In Java/Maven world "Profile" has a different meaning.
"Convention" is honest and too weak to build on.

What I am certain of is that the thing exists, that it is not the same as the mapping that executes it, and that I have been shipping it unnamed since the first Draw.io diagram that meant something.
