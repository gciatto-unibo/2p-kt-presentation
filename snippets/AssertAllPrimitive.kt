val assert_all = Signature("assert_all", 1)

fun assertAll(req: Solve.Request<ExecutionContext>): Sequence<Solve.Response> {
    return when (val arg1: Term = req.arguments[0]) {
        is List -> req.replySuccess {
            addDynamicClauses(arg1.toList().map { Rule.of(it as Struct) })
        }
        else -> throw TypeError.forArgument(req.context, req.signature, TypeError.Expected.LIST, arg1, 0)
    }
    .let { sequenceOf(it) }
}

val mylib = Library.aliased(
    alias = "prolog.mylib", 
    primitives = mapOf(assert_all to ::assertAll))

val solver = Solver.classic.solverOf(Libraries.of(mylib))

val factsToAdd = List.of(Atom.of("a"), Atom.of("b"), Atom.of("c"))

println(solver.solveOnce(Struct.of("assert_all", factsToAdd))) // yes
println(solver.dynamicKb) // a. b. c.