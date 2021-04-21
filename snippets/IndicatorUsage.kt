val fa1 = Struct.of("f", Atom.of("a"), Integer.ONE) // f(a, 1)

val f2: Indicator = fa1.indicator // f/2

val f2Name: Term = f2.nameTerm: // Atom.of("f")
val f2Arity: Term = f2.arityTerm // Integer.of(2)
val f2N: String? = f2.indicatedName // "f"
val f2A: Int? = f2.indicatedArity: // 2

val fN: Indicator = Indicator.of(Atom.of("f"), Var.of("N")) // f/N

val fNName: Term = fN.nameTerm: // Atom.of("f")
val fNArity: Term = fN.arityTerm // Var.of("N")
val fNN: String? = fN.indicatedName // "f"
val fNA: Int? = fN.indicatedArity: // null