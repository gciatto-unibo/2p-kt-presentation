val rule: Rule = Scope.empty {
    ruleOf(
        structOf("anchestor", varOf("X"), varOf("Y")),
        structOf("parent", varOf("X"), varOf("Z")),
        structOf("parent", varOf("Z"), varOf("Y"))
    ) // anchestor(X_1, Y_2) :- parent(X_1, Z_3), parent(Z_3, Y_2).
}

// or, alternatively:

val s = Scope.empty()
val rule: Rule = s.ruleOf(
    s.structOf("anchestor", s.varOf("X"), s.varOf("Y")),
    s.structOf("parent", s.varOf("X"), s.varOf("Z")),
    s.structOf("parent", s.varOf("Z"), s.varOf("Y"))
) // anchestor(X_1, Y_2) :- parent(X_1, Z_3), parent(Z_3, Y_2).