val queue = ClauseCollection.queueOf(
    Fact.of(Struct.of("f", Integer.of(1)))
) // f(1)

val queue2 = queue.addLast(
    Fact.of(Struct.of("f", Integer.of(2)))
) // f(1), f(2)

val queue3 = queue2.add(
    Fact.of(Struct.of("f", Integer.of(3)))
) // f(1), f(2), f(3)

val queue4 = queue3.addFirst(
    Fact.of(Struct.of("f", Integer.of(4)))
) // f(4), f(1), f(2), f(3)