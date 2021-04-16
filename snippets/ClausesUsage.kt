val rule = Rule.of(
    Struct.of("anchestor", Atom.of("abraham"), Atom.of("jacob")),
    Struct.of("parent", Atom.of("abraham"), Atom.of("isaac")),
    Struct.of("parent", Atom.of("isaac"), Atom.of("jacob"))
) // anchestor(abraham, jacob) :- parent(abraham, isaac), parent(isaac, jacob).

println(rule.head) // anchestor(abraham, jacob)
println(rule.body) // (parent(abraham, isaac), parent(isaac, jacob))
 
val fact = Fact.of(
    Struct.of("parent", Atom.of("abraham"), Atom.of("isaac"))
) // parent(abraham, isaac).

println(fact.head) // parent(abraham, isaac)
println(fact.body) // true

val directive = Directive.of(
    Struct.of("anchestor", Var.of("X"), Var.of("Y"))
) // :- anchestor(X, Y).

println(directive.head) // null
println(directive.body) // anchestor(X, Y)