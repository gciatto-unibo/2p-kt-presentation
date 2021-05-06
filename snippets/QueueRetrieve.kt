val queue = ClauseCollection.queueOf(
    Fact.of(Struct.of("f", Integer.of(1))),
    Fact.of(Struct.of("f", Integer.of(2))),
    Fact.of(Struct.of("f", Integer.of(3))),
) // f(1), f(2), f(3)

val successfulRetrieve = queue.retrieveFirst(
    Fact.of(Struct.of("f", Integer.of(1)))
)

println(successfulRetrieve.firstClause) // f(1)

val queue2 = successfulRetrieve.collection // f(2), f(3)

val failedRetrieve = queue2.retrieveFirst(
    Fact.of(Struct.of("f", Integer.of(1)))
)
val queue3 = failedRetrieve.collection // f(2), f(3)