val rule: Rule = Scope.empty {
    ruleOf(
        structOf("anchestor", varOf("X"), varOf("Y")),
        structOf("parent", varOf("X"), varOf("Z")),
        structOf("parent", varOf("Z"), varOf("Y"))
    ) // anchestor(X_1, Y_2) :- parent(X_1, Z_3), parent(Z_3, Y_2).
}

val copy = rule.freshCopy() // anchestor(X_4, Y_5) :- parent(X_4, Z_6), parent(Z_6, Y_5).

println(rule == copy) // false
println(rule.equals(copy, useVarCompleteName = false)) // true