val theory = Theory.of(
    Fact.of(Struct.of("f", Integer.of(1))),
    Fact.of(Struct.of("f", Integer.of(2))),
    Fact.of(Struct.of("f", Integer.of(3))),
    Fact.of(Struct.of("g", Integer.of(1))),
    Fact.of(Struct.of("g", Integer.of(2))),
) // f(1), f(2), f(3), g(1), g(2)

val theory2 = theory.abolish(
    Indicator.of("f", 1) // retracts all f/1 clauses
) // g(1), g(2)