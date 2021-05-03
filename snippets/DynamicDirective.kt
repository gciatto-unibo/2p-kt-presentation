val theory = Theory.of(
    Fact.of(Struct.of("f", Atom.of("a"))),                    // f(a).
    Fact.of(Struct.of("f", Atom.of("b"))),                    // f(b).
    Directive.of(Struct.of("dynamic", Indicator.of("g", 1))), // :- dynamic(g/1).
    Fact.of(Struct.of("g", Integer.of(1))),                   // g(1).
    Fact.of(Struct.of("g", Integer.of(2))),                   // g(2).
)

val solver = Solver.classic.solverWithDefaultBuiltins(
    staticKb = theory
)

println(solver.staticKb) // IndexedTheory{ f(a) :- true. f(b) :- true. :- dynamic(g/1) }
println(solver.dynamicKb) // MutableIndexedTheory{ g(1) :- true. g(2) :- true }