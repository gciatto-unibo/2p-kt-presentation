Scope.empty {
    val unificator = Unificator.default

    val term = Struct.of("father", Atom.of("abraham"), Atom.of("isaac"))
    val goal = Struct.of("father", Var.of("abraham"), Atom.of("isaac"))

    val substitution: Substitution = unificator.mgu(term, goal) // {}
}