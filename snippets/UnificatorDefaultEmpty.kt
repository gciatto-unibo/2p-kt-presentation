prolog {
    val unificator = Unificator.default

    val term = "father"("abraham", "isaac")
    val goal = "father"("abraham", "isaac")

    val substitution: Substitution = unificator.mgu(term, goal) // {}
}