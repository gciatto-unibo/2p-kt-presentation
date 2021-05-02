val prolog = Solver.classic.solverOf(
    staticKb = Theory.of(
        { factOf(structOf("nat", atomOf("z"))) },           // nat(z).
        {
            ruleOf(
                structOf("nat", structOf("s", varOf("Z"))), // nat(s(Z)) :-
                structOf("nat", varOf("Z"))                 //   nat(Z).
            )
        }
    )
)

val goal = Struct.of("nat", Var.of("X"))
val solutions = prolog.solve(goal, SolveOptions.someLazily(limit = 1000))

println(solutions)