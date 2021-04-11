val unificator = Unificator.default

val t1 = Struct.of("father", Atom.of("abraham"), Atom.of("isaac"))
val t2 = Struct.of("father", Var.of("X"), Atom.of("isaac"))

val substitution: Substitution = unificator.mgu(t1, t2) // {X_0=abraham}
val match: Boolean = unificator.match(t1, t2) // true
val result: Term? = unificator.unify(t1, t2) // father(abraham, isaac)