object FindAll : TernaryRelation.NonBacktrackable<ExecutionContext>("findall") {
    override fun Solve.Request<ExecutionContext>.computeOne(
        x: Term, y: Term, z: Term
    ): Solve.Response {
        ensuringArgumentIsInstantiated(1)
        ensuringArgumentIsCallable(1)
        val solver = subSolver()
        val solutions = solver.solve(y as Struct).toList()
        val error = solutions.asSequence()
            .filterIsInstance<Solution.Halt>()
            .firstOrNull()
        if (error != null) {
            return replyException(error.exception.pushContext(context))
        }
        val mapped = solutions.asSequence()
            .filterIsInstance<Solution.Yes>()
            .map { x[it.substitution].freshCopy() }
        return replyWith(z mguWith List.of(mapped))
    }
}