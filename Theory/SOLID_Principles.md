# Five SOLID Principles

- **S**ingle responsibility principle
- **O**pen closed principle
- **L**iskov substitution principle
- **I**nterface segregation principle
- **D**ependency Inversion Principle

## Benefits

- loosely coupled code = improves testability, maintainability, replace-ability
- cohesive
- encapsulating


## Single Responsibility Pronciple

- A class should have one and only one reason to change, meaning that a class should have only one job.
- A God object is an object that knows too much or does too much :thumbsdown: The God object is an example of an anti-pattern.
- Too much responsibility leads to coupling (complicates change)
- Components with low cohesion are doing tasks that are not related to their responsibilities.
- Reasons for change: adding new features; correcting faults; refactoring.
- Isolate change by looking closely at the things that make the whole and separate them logically.
- Keep track of the dependencies by checking i.e. if a constructor/method has too many input parameters thus many dependencies.
- Refactor early (to design patterns)

## Open Close Principle

- Objects or entities should be open for extension, but closed for modification.
- Have a way to add new features but keep code in good standing.
- Existing code is immutable; extend with composition (avoid inheritance everywhere)
- Keep in mind future changes (scope meetings)

## Liskov substitution principle

- Let q(x) be a property provable about objects of x of type T. Then q(y) should be provable for objects y of type S where S is a subtype of T. (All this is stating is that every subclass/derived class should be substitutable for their base/parent class.)
- If not: class hierarchies get messy; Unit tests for the superclass never succeed for sub-class
- Keep base abstractions as simple and minimal as possible.
- Code reviews very helpful
- [Composition over inheritance](https://www.thoughtworks.com/insights/blog/composition-vs-inheritance-how-choose)

## Interface segregation principle

- A client should never be forced to implement an interface that it doesn't use or clients shouldn't be forced to depend on methods they do not use.
- Related to Single Responsibility Principle
- Keep interfaces thin or fine-grained/no unused methods => gives flexibility
- Thin interfaces are called *role interfaces* => easier to refactor
- If nescessary combine interfaces

## Dependency inversion principle

- Entities must depend on abstractions not on concretions. It states that the high level module must not depend on the low level module, but they should depend on abstractions.
http://wiki.c2.com/?DependencyInversionPrinciple

- **loosely coupling** => no client has to be changed when code it depends has changed; better it has no knowlegde of the change.
- **testability and replaceability** components can be replaced with alternative with same service.
- Drawback: dependency inversion container is required and needs to be configured. Takes care of injection.