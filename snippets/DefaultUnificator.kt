prolog {
    val unificator = Unificator.default

    val term = "father"("abraham", "isaac")
    val goal = "father"("X", "isaac")

    val substitution: Substitution = unificator.mgu(term, goal) // {X_0=abraham}
    val match: Boolean = unificator.match(term, goal) // true
    val result: Term? = unificator.unify(term, goal) // father(abraham, isaac)
}