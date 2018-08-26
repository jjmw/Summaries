# Bounded context (BC)
        **== autonomous components (own domain models an ubiquitous language.**
* No dependencies on each other at runtime
* should be able to run in isolation
* updated/modified independent from each other

When **CQRS** pattern (= Command Query Responsibility Segregation) in bounded context:
use events
* BC can respond to incomming events
* can publish outgoing events to subscribers

(evens == one-way, asynchronous messages publish information about something that has already happened)

Events enable to maintain loose coupling between BC

Documentation should cover: which BC publishes which integration events, which BC subscribes to which integration events

When BC is modified/updated events can change. A BC must be robust for such modifications ===> 
## solution is a anti-corruption layer
* for verifying is an incoming integration event makes sense. ie type correct.
* translate incoming integration events (mapping to different type, converting to different version of event)

Common approaches for getting data from legacy systems to a BC:
1. reading the database: BC that implements CQRS reads from the database of the legacy system (LC). Useful if LC has no API, but is now coupled!!!)
1. Generating events from database: implement monitoring program that is triggered when database is updated and generates events
    decoupled BC, but an additional program to maintain
1. Modifying legacy system: publish events directly => potential consistency problem: ensure events are realy genereated, when transactions are suscessful.
    access to source code LC
1. Implications for event sourcing: if all events published by aggregates in that domain are persisted to event store. Where are the events stored? Should be ie able to rebuild a state after a failure.

Source: komt nog
