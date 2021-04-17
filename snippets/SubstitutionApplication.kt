val X = Var.of("X"); val Y = Var.of("Y"); val Z = Var.of("Z")

val r1 = Rule.of(
    Struct.of("anchestor", X, Y),
    Struct.of("parent", X, Z),
    Struct.of("parent", Z, Y)
) // anchestor(X, Y) :- parent(X, Z), parent(Z, Y).

val u = Substitution.unifier(
    X to Atom.of("abraham"),
    Y to Atom.of("jacob")
) // {X=abraham, Y=jacob}

val r2 = r1.apply(u) // anchestor(abraham, jacob) :- parent(abraham, Z), parent(Z, jacob).
val r3 = u.applyTo(r1) // same as above

val r4 = r2[Substitution.fail()] // throws SubstitutionApplicationException