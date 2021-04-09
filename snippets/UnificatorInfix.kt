prolog {
    val term = "father"("abraham", "isaac")
    val goal = "father"("X", "isaac")

    val substitution: Substitution = term mguWith goal // {X_0=abraham}
    val match: Boolean = term matches goal // true
    val result: Term? = term unifyWith goal // father(abraham, isaac)
}