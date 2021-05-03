object MyLibrary : AliasedLibrary by
    Library.aliased(
        alias = "alias.of.the.lib",
        operatorSet = OperatorSet(/* custom operators here */),
        theory = Theory.of(/* provide rules/facts here */),
        primitives = mapOf(
            Signature("f", 1) to { request: Solve.Request<ExecutionContext> ->
                // implement primitive here
            }
        ),
        functions = mapOf(
            Signature("+", 2) to { request: Compute.Request<ExecutionContext> ->
                // implement function here here
            }
        )
    )