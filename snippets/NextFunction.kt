val next = Signature("next", 1)

fun next(req: Compute.Request<ExecutionContext>): Compute.Response {
    return when(val arg1: Term = req.arguments[0]) {
        is Integer -> req.replyWith(Integer.of(arg1.intValue + BigInteger.ONE))
        else -> req.replyWith(arg1)
    }
}

val mylib = Library.aliased(alias = "prolog.mylib", functions = mapOf(next to ::next))

val solver = Solver.classic.solverWithDefaultBuiltins(Libraries.of(mylib))

val goal = Struct.of("is", Var.of("X"), Struct.of("next", Integer.ONE)) // X is next(1)
println(solver.solveOnce(goal)) // X=2