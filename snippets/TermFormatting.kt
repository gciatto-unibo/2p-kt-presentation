val expression = Scope.empty {
    structOf("+",
        listOf(varOf("A"), varOf("B")),
        setOf(
            structOf("-", varOf("X"), intOf(1)),
            structOf("\$VAR", intOf(2))
        )
    )
} // [A, B] + (X - 1, '$VAR'(2))

println( TermFormatter.canonical().format(expression) )
    // '+'('.'(_0, '.'(_0, [])), '{}'(','('-'(_0, 1), '$VAR'(2))))
println( TermFormatter.default(OperatorSet.DEFAULT).format(expression) )
    // [_0, _0] + {_0 - 1, C0}
println( TermFormatter.readable(OperatorSet.DEFAULT).format(expression) )
    // [A, B] + {X - 1, C0}
println( TermFormatter.prettyVariables().format(expression) )
    // '+'([A, B], {'-'(X, 1), '$VAR'(2)})
println( TermFormatter.prettyExpressions(true, OperatorSet.DEFAULT).format(expression) )
    // [A, B] + {X - 1, '$VAR'(2)}