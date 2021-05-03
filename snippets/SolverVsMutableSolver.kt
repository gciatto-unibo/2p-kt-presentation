import it.unibo.tuprolog.solve.classic.stdlib.DefaultBuiltins

val theory = Theory.of(
    Fact.of(Struct.of("f", Atom.of("a"))), // f(a).
    Fact.of(Struct.of("f", Atom.of("b"))), // f(b).
    Fact.of(Struct.of("f", Atom.of("c")))  // f(c).
)
val fact = Struct.of("g", Integer.ONE)  // g(1).

// solvers require information to be provided at instantiation time:
val solver: Solver = Solver.classic.solverOf(
    libraries = Libraries.of(DefaultBuiltins),
    staticKb = theory
)
// ... side effects must be provoked through resolution
solver.solveOnce(Struct.of("assert", fact))
println(solver.dynamicKb) // MutableIndexedTheory{ g(1) :- true }

// mutable solvers can be lately configured:
val mutableSolver: MutableSolver = Solver.classic.mutableSolverOf()
mutableSolver.loadLibrary(DefaultBuiltins)
mutableSolver.loadStaticKb(theory)
// ... side effects can be provoked via ad-hoc methods
mutableSolver.assertZ(fact)
println(solver.dynamicKb) // MutableIndexedTheory{ g(1) :- true }