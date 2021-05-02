val prolog = Solver.classic.solverWithDefaultBuiltins(
    staticKb = Theory.indexedOf(
        Fact.of(Struct.of("f", Atom.of("a"))), // f(a).
        Fact.of(Struct.of("f", Atom.of("b"))), // f(b).
        Fact.of(Struct.of("f", Atom.of("c")))  // f(c).
    )
)

val goal = Struct.of("f", Var.of("X"))

val solutions = prolog.solve(goal, SolveOptions.allLazilyWithTimeout(1 /* ms */))

for (solution in solutions) {
    println(solution.query) // f(X_2)
    println(solution.isHalt) // true
    println(solution.exception) // it.unibo.tuprolog.solve.exception.TimeOutException
}