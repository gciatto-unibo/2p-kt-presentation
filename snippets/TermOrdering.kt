val terms = listOf(
      Atom.of("z"),                                // z
      Struct.of("g", Atom.of("Z")),                // g(z)
      Integer.ONE,                                 // 1
      Real.ONE,                                    // 1.0
      Var.of("X"),                                 // X
      Integer.of(2),                               // 2
      Real.of(-3.4),                               // -3.4
      Var.of("F"),                                 // F
      Struct.of("f", Atom.of("A"), Integer.ZERO),  // f(A, 0)
      Atom.of("a")                                 // a
)

terms.sorted().forEach { println(it) }
// F, X, -3,4, 1.0, 1, 2, a, z, g(z), f(A, 0)