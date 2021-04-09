prolog {
    val unificator = Unificator.default
    val cached = Unificator.cached(unificator, capacity = 5)

    val term = "father"("abraham", "isaac")
    val goal = "father"("X", "isaac")

    val substitution: Substitution = cached.mgu(term, goal) // {X_0=abraham}
    val match: Boolean = cached.match(term, goal) // true
    val result: Term? = cached.unify(term, goal) // father(abraham, isaac)
}