val theory = Theory.of(
    Fact.of(Struct.of("f", Integer.of(1))),
    Fact.of(Struct.of("f", Integer.of(2))),
    Fact.of(Struct.of("f", Integer.of(3))),
) // f(1), f(2), f(3)

val successfulRetract = theory.retract(
    Fact.of(Struct.of("f", Integer.of(1)))
)
val theory2 = successfulRetract.theory // f(2), f(3)

val failedRetract = theory2.retract(
    Fact.of(Struct.of("f", Integer.of(4)))
)
val theory3 = failedRetract.theory // f(2), f(3)