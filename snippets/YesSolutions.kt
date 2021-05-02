val prolog = Solver.classic.solverWithDefaultBuiltins(
    staticKb = Theory.indexedOf(
        Fact.of(Struct.of("f", Atom.of("a"))), // f(a).
        Fact.of(Struct.of("f", Atom.of("b"))), // f(b).
        Fact.of(Struct.of("f", Atom.of("c")))  // f(c).
    )
)

val goal = Struct.of("f", Var.of("X"))

val solutions: Sequence<Solution> = prolog.solve(goal)

println(solutions) // kotlin.sequences.ConstrainedOnceSequence@7f362f22

val i = solutions.iterator()

while (i.hasNext()) {
    val solution = i.next()
    println(solution.query) // f(X_2), f(X_2), f(X_2)
    println(solution.isYes) // true, true, true
    println(solution.substitution) // {X_2=a}, {X_2=b}, {X_2=c}
}