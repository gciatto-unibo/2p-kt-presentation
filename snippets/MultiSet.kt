val multiSet = ClauseCollection.multiSetOf(
    Fact.of(Struct.of("f", Integer.of(1))),
    Fact.of(Struct.of("f", Integer.of(2))),
    Fact.of(Struct.of("f", Integer.of(3))),
)

val matching = multiSet[Fact.of(Struct.of("f", Var.of("X")))]
    // f(1), f(2), f(3)

val count = multiSet.count(Fact.of(Struct.of("f", Var.of("X")))
    // 3