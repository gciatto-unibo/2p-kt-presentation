val prolog = Solver.classic.solverWithDefaultBuiltins()

val solution = prolog.solveOnce(Struct.of("halt", Integer.of(2)))

println(solution) // Halt(query=halt(2), exception=it.unibo.tuprolog.solve.exception.HaltException)
println((solution.exception as HaltException).exitStatus) // 2