val theory1 = Theory.of(
    Fact.of(Struct.of("f", Atom.of("a"))), // f(a).
    Fact.of(Struct.of("f", Atom.of("b"))), // f(b).
)
val theory2 = Theory.of(
    Fact.of(Struct.of("g", Integer.of(1))), // g(1).
    Fact.of(Struct.of("g", Integer.of(2))), // g(2).
)

val solver = Solver.classic.mutableSolverWithDefaultBuiltins()
println(solver.staticKb) // IndexedTheory{  }
println(solver.dynamicKb) // MutableIndexedTheory{  }

solver.loadStaticKb(theory1)
solver.loadDynamicKb(theory2)
println(solver.staticKb) // IndexedTheory{ f(a) :- true. f(b) :- true }
println(solver.dynamicKb) // MutableIndexedTheory{ g(1) :- true. g(2) :- true }