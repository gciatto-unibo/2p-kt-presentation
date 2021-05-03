val messages = mutableListOf<String>()

val solver = Solver.classic.solverWithDefaultBuiltins(
    otherLibraries = Libraries.of(IOLib),
    stdIn = InputChannel.of("hello"),
    stdOut = OutputChannel.of { messages += it }
)

val goal = Scope.empty {
    tupleOf(
        structOf("get_char", varOf("X")),
        structOf("write", varOf("X"))
    )
} // ?- get_char(X), write(X).

for (i in 0 until "hello".length) {
    println(solver.solveOnce(goal)) // X=h, X=e, X=l, ...
}

println(messages) // [h, e, l, l, o]