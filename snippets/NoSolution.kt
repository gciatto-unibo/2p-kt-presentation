val prolog = Solver.classic.solverOf()

val goal = Struct.of("f", Var.of("X"))

val solution = prolog.solveOnce(goal)

println(solution) // No(query=f(X_0))