val reduce = Signature("reduce", 2)

fun reduce(req: Solve.Request<ExecutionContext>): Sequence<Solve.Response> {
    val arg1: Term = req.arguments[0]
    return when (val arg2: Term = req.arguments[1]) {
        is Var -> throw InstantiationError.forArgument(req.context, req.signature, arg2, 1)
        else -> {
            val reducer = ExpressionReducer(req, 1)
            req.replyWith(arg1 mguWith arg2.accept(reducer))
        }
    }.let { sequenceOf(it) }
}

val mylib = Library.aliased(
    alias = "prolog.mylib", 
    primitives = mapOf(reduce to ::reduce))

val solver = Solver.classic.solverWithDefaultBuiltins(Libraries.of(mylib))

val expression = Struct.of("f", Struct.of("+", Integer.ONE, Integer.of(2))) // f(1 + 2)
val goal = Struct.of("reduce", Var.of("X"), expression) // reduce(X, f(1 + 2))
println(solver.solveOnce(goal)) // X=f(3)