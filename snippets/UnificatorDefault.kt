Scope.empty {
    val unificator = Unificator.default

    val term = Struct.of("father", Atom.of("abraham"), Atom.of("isaac"))
    val goal = Struct.of("father", Var.of("X"), Atom.of("isaac"))

    val substitution: Substitution = unificator.mgu(term, goal) // {X_0=abraham}
    val match: Boolean = unificator.match(term, goal) // true
    val result: Term? = unificator.unify(term, goal) // father(abraham, isaac)
}