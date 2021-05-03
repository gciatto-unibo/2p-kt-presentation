val solver1 = Solver.classic.solverOf(
    flags = FlagStore.DEFAULT,
    warnings = OutputChannel.warn() // default
)
solver1.solveOnce(Atom.of("missing")) // no (prints warning)
    // No such a predicate: missing/0

val solver2 = Solver.classic.solverOf(
    flags = FlagStore.DEFAULT.set(Unknown, Unknown.FAIL),
    warnings = OutputChannel.warn() // default
)
solver2.solveOnce(Atom.of("missing")) // no (prints noting)

val solver3 = Solver.classic.solverOf(
    flags = FlagStore.DEFAULT.set(Unknown, Unknown.ERROR),
    warnings = OutputChannel.warn() // default
)
solver3.solveOnce(Atom.of("missing")) // halt
    // existence_error(procedure, missing/0)