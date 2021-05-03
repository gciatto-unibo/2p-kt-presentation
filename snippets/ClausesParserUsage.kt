val parser = ClausesParser.withDefaultOperators
val input = """
    grandfather(X, Y) :- father(X, Z), father(Z, Y).
    father(abraham, isaac).
    father(isaac, jacob).
""".trimIndent()

val theory: Theory = parser.parseTheory(input)
val clauses: List<Clause> = parser.parseClauses(input)
val lazyClauses: Sequence<Clause> = 
    parser.parseClausesLazily(input)