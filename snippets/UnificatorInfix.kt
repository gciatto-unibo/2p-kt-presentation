Scope.empty {
    val term = Struct.of("father", Atom.of("abraham"), Atom.of("isaac"))
    val goal = Struct.of("father", Var.of("X"), Atom.of("isaac"))

    val substitution: Substitution = term mguWith goal // {X_0=abraham}
    val match: Boolean = term matches goal // true
    val result: Term? = term unifyWith goal // father(abraham, isaac)
}