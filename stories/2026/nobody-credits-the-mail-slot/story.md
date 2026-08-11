*Boundaries Are the Architecture, Protocols Are How You Knock*

Published on [Medium](https://medium.com/nasdanika/nobody-credits-the-mail-slot-mcp-microservices-and-the-return-of-the-big-building-394b223e950d) on July 15, 2026.
Tags: Software Architecture, System Design, Microservices, Model Context Protocol, Artificial Intelligence

<img src="https://miro.medium.com/v2/1*Ne0yAJFYpW_mNjRwz5cRYQ.png" alt="Nobody Credits the Mail Slot" style="width: 100%;">

Nowadays MCP is in every keynote, every roadmap. However, MCP is a protocol — a delivery mechanism. Agents use tools; MCP standardizes how tools (and resources, and prompts) are delivered to them. Anthropic’s own tagline:

> *USB-C port for AI*

already concedes the point: port standards are valuable because they are boring. In the same way a standard shipping container is valuable. But nobody credits the container for what is inside. Two metaphors to illustrate the point.

## Buildings

### The apartment building (monolith)

<img src="https://miro.medium.com/v2/1*3cs_uVth7gNdC-DCAz2BKg.png" alt="The apartment building" style="width: 100%;">

People used to live in huge apartment buildings. Everyone under one roof: cheap to heat, one address, you could borrow sugar from a neighbor by knocking on a wall. That was the monolith, and for a while it was fine.

Then the building got big. Noisy neighbors kept you up at night (one team’s hot loop starved everyone’s threads). Graffiti crept up the stairwells (nobody owned the shared code, so everybody defaced it). A busted pipe in one apartment flooded three floors below (one module’s failure took down modules that had nothing to do with it). Cockroaches from one kitchen colonized the whole building (a bad dependency, once in, was everywhere). The lease said nothing about any of this, because inside one building there are no contracts, only neighbors.

### Suburbia (microservices)

<img src="https://miro.medium.com/v2/1*IEHKeyTqVUqq_7t1QJYUgQ.png" alt="Suburbia" style="width: 100%;">

So people invented suburbia. Everyone got their own house: their own walls, their own pipes, their own pest control. Microservices. And the brochure was accurate, as far as it went. Your neighbor’s flood was now strictly your neighbor’s problem.

But now nothing was a knock on the wall anymore. To borrow sugar you had to get dressed (serialize), walk or drive (make a network call), and hope about the weather (outages, latency). The streets had gangs, so every door needed a lock (TLS), and when someone knocked you had to check they were who they claimed to be (authentication). Every house ran its own furnace, its own water heater, its own alarm system: the operational overhead that used to be amortized across the whole building was now duplicated per household. Some families spent more time maintaining the house than living in it.

Please note, I’m not saying that microservices are wrong. In any non-trivial endeavor there is a huge design space and a tremendous number of decisions and trade-offs to make, paraphrasing Steve Jobs:

So both monoliths and microservices are different points in the design space. And what is a monolith? It is a *macro*service. Monolith-microservice are not two points, but rather a continuum. An average Spring Booot microservice carries ~600 Maven dependencies — some may say that it sounds monolithy, doesn’t it?

### The office building

<img src="https://miro.medium.com/v2/1*0J0ekTXYjuPoUeWnzUSnXQ.png" alt="The office building" style="width: 100%;">

And slowly it dawned on people that the problem with the apartment building was never the building. It was that inside it, anybody could go anywhere. No badges, no locked floors, no rules about who enters whose kitchen. Colocation was fine; the free-for-all was not.

So people are moving back into big buildings, but this time they run them like office buildings: badges, and doors that check them. Clear zones, controlled entrances, and you still get the shared heating, one address, and hallway conversations instead of commutes. The modular monolith.

There are two ways to run such a building. JPMS is the strict way: badge readers on every door, and if your badge does not open the door, you are not getting in, period (the compiler and the runtime enforce the boundary).

<img src="https://miro.medium.com/v2/1*wfMdB4YbYfmlSZoFkkRC6w.png" alt="JPMS badge access" style="width: 100%;">

Spring Modulith is the boarding-school way: every house has its own uniform, so a pupil wandering into the wrong common room is spotted instantly and walked back by a prefect (boundaries live in package conventions, and the test suite catches violations before they ship). One is a locked door, the other is high-visibility social enforcement. Both beat the free-for-all.

*Full disclaimer: I know JPMS well and Spring Modulith mostly from its documentation; corrections welcome in the comments.*

### Where MCP fits

<img src="https://miro.medium.com/v2/1*Jg7fmg1g0qzvAxOH9BavSA.png" alt="Where MCP fits" style="width: 100%;">

Here is the part the current hype gets backwards. Whatever kind of building you live in, deliveries still have to arrive, and it helps enormously if every courier from every company follows the same procedure at the front desk: sign here, badge there, packages through this window. That standardized front-desk procedure is MCP. Agents use tools; MCP is a standard way to deliver tools to them.

A standard delivery protocol is genuinely valuable, precisely because it is boring: any courier can serve any building without a custom arrangement per pair. But nobody confuses the front-desk procedure with the contents of the packages. The value is in the tools, the data, the capabilities being delivered. The protocol just makes the handoff cheap. Celebrating MCP as if it were the intelligence is celebrating the mail slot for the quality of the letters.

## The version that is literally true — Organizations

If buildings feel like a stretch, here is the version that is not a metaphor at all. Conway’s law: systems mirror communication structures.

A monolith is one company with everyone in one open office. Communication is a shoulder tap: instant, informal, free. That is its superpower and its disease. Nothing stops anyone from tapping anyone, so over time everything depends on everything, nobody can say who owns what, and one team’s chaos (a reorg, a fire drill, a bad quarter) ripples through the whole floor.

Microservices are what happens when you spin every team off into its own company. Now every interaction is formal: contracts (APIs), invoices, SLAs, procurement. You verify who you are dealing with (authentication), you put agreements in writing (schemas), you accept that couriers get delayed and shipments get lost (network failures), and you keep lawyers on retainer (serialization, versioning, compatibility). Amazon’s two-pizza team is exactly this: a team small enough to feed with two pizzas, owning a service end to end and talking to other teams only through published interfaces. A two-pizza team is the organizational form of a microservice. The industry even has a name for choosing your architecture by choosing your org chart: the inverse Conway maneuver.

The formality buys real things: autonomy, independent scaling, blast-radius containment, the ability to fire a vendor. But everyone who has worked across company boundaries knows the tax. What used to be a shoulder tap is now a statement of work.

The modular monolith is the middle that businesses have always known about: one company with real departments. Shared payroll, shared facilities, one legal entity (one deployment, one operational surface), but clear departmental boundaries, defined interfaces between them, and badge access to sensitive areas. Finance does not wander into Engineering’s repos, and Engineering does not book journal entries, yet neither files an invoice to talk to the other.

Inside this frame the two Java flavors are two governance styles. JPMS is compliance-grade: physical access control, the badge either opens the door or it does not. Spring Modulith is culture-grade: strong conventions, visible team identities, and an internal audit (the test suite) that flags anyone found in the wrong department before the quarter closes.

### Where MCP fits

MCP is standardized procurement paperwork: the EDI of the agent world. When every vendor accepts the same purchase-order format, onboarding a new supplier becomes cheap, and that is worth real money. But no company ever became great because of its purchase-order format. The value is in what the suppliers actually deliver. Agents use tools; MCP just standardizes how tools are procured and delivered. Standards make markets; they are not the merchandise. Anyone selling you “an MCP strategy” is selling you a mail-slot strategy.

## One-line moral

Architecture is org design under Conway’s law. Choose your boundaries the way you would choose your org chart, and treat protocols, MCP included, as the paperwork that lets boundaries be crossed cheaply, not as the strategy.
