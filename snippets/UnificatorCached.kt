val unificator = Unificator.default
val cached = Unificator.cached(unificator, capacity = 5)

val term = Struct.of("father", Atom.of("abraham"), Atom.of("isaac"))
val goal = Struct.of("father", Var.of("X"), Atom.of("isaac"))

val substitution: Substitution = cached.mgu(term, goal) // {X_0=abraham}
val match: Boolean = cached.match(term, goal) // true
val result: Term? = cached.unify(term, goal) // father(abraham, isaac)