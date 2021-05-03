val gt = Signature("gt", 2)

fun greaterThan(req: Solve.Request<ExecutionContext>): Sequence<Solve.Response> {
    val arg1: Term = req.arguments[0] ; val arg2: Term = req.arguments[1]

    if (arg1 !is Numeric)
        throw TypeError.forArgument(req.context, req.signature, TypeError.Expected.NUMBER, arg1, 0)
    if (arg2 !is Numeric)
        throw TypeError.forArgument(req.context, req.signature, TypeError.Expected.NUMBER, arg2, 1)

    return if (arg1.castToNumeric().decimalValue > arg2.castToNumeric().decimalValue) 
        sequenceOf(req.replySuccess()) 
    else 
        sequenceOf(req.replyFail())
}

val mylib = Library.aliased(alias = "prolog.mylib", primitives = mapOf(gt to ::greaterThan))

val solver = Solver.classic.solverOf(Libraries.of(mylib))

println(solver.solveOnce(Struct.of("gt", Integer.ONE, Integer.ZERO))) // yes
println(solver.solveOnce(Struct.of("gt", Integer.ZERO, Integer.ONE))) // no
println(solver.solveOnce(Struct.of("gt", Integer.ONE, Atom.of("a")))) // type_errors