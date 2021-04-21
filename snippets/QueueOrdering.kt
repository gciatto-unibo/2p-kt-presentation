val queue = ClauseCollection.queueOf(
    Fact.of(Struct.of("f", Integer.of(1))),
    Fact.of(Struct.of("f", Integer.of(2))),
) // f(1), f(2)

val fifoOrdered = queue.getFifoOrdered(
    Fact.of(Struct.of("f", Var.of("X")))
) // f(1), f(2)
val lifoOrdered = queue.getLifoOrdered(
    Fact.of(Struct.of("f", Var.of("X")))
) // f(2), f(1)