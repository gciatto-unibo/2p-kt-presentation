val prolog = Solver.classic.solverWithDefaultBuiltins(
    staticKb = Theory.indexedOf(
        Fact.of(Struct.of("f", Atom.of("a"))), // f(a).
        Fact.of(Struct.of("f", Atom.of("b"))), // f(b).
        Fact.of(Struct.of("f", Atom.of("c")))  // f(c).
    )
)

val goal = Struct.of("f", Var.of("X"))

val solutions: List<Solution> = prolog.solveList(goal)

println(solutions.size) // 3
println(solutions) // [Yes(query=f(X_2), substitution={X_2=a}), Yes(query=f(X_2), substitution={X_2=b}) Yes(query=f(X_2), substitution={X_2=c})]

for (solution in solutions) {
    println(solution.query) // f(X_2), f(X_2), f(X_2)
    println(solution.isYes) // true, true, true
    println(solution.substitution) // {X_2=a}, {X_2=b}, {X_2=c}
}