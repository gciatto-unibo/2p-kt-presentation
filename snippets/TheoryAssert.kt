val theory = Theory.empty()

val theory2 = theory.assertA(
    Fact.of(Struct.of("f", Integer.of(1)))
) // f(1)

val theory3 = theory2.assertA(
    Fact.of(Struct.of("f", Integer.of(2)))
) // f(2), f(1)

val theory4 = theory3.assertZ(
    Fact.of(Struct.of("f", Integer.of(3)))
) // f(2), f(1), f(3)