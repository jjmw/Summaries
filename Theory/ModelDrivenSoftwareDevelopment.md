# 5 types:


1. Programming, just coding 
2. Code Generation
    automated programming ie what a IDE does.
3. Model Driven Abstraction (MDA)
    Construct platform independent model that is transformed into an platform dependent model using [model transformations](http://www.theenterprisearchitect.eu/blog/2008/02/18/mda-and-model-transformation). From the platform dependent model the source code is generated.
    The MDA is mainly aimed at technical variability.
4. Domain Specific Languages (DSL)
    DSLs are small languages tailored to a specific domain. So multiple small models.
    DSLs can vary in structure, variablity and notation.
    Most DSL approaches contain a direct translation between DSLs and their execution by using code generation or the direct interpretation of the DSLs
5. Model Driven Engineering (MDE) => business-centric
    We can also create models of the using system, i.e. creating models of the organization which is going to use the software. Once we have modeled the so-called problem domain, we can make translations to a model of the solution domain. These translations or transformations don’t necessarily have to be automated, in some cases that’s not even possible. However, they need to be supported by appropriate tools and methodologies.
    [Horizontal transformations](http://www.theenterprisearchitect.eu/blog/2008/11/27/the-place-of-architecture-in-model-driven-engineering): from problem to solution domain
    Vertical transformations: from solution domain to executable model.
    The challenges of MDE are in appropriate tooling, methodologies, patterns, templates, reference architectures, and industry standards.

[Source](http://www.theenterprisearchitect.eu/blog/2009/03/31/5-types-of-model-driven-software-development/)