package it.unibo.tuprolog.solve.stdlib.primitive

import it.unibo.tuprolog.core.*
import it.unibo.tuprolog.solve.*
import it.unibo.tuprolog.solve.primitive.*
import it.unibo.tuprolog.unify.Unificator.Companion.mguWith

object FindAll : TernaryRelation.NonBacktrackable<ExecutionContext>("findall") {
    override fun Solve.Request<ExecutionContext>.computeOne(first: Term, second: Term, third: Term): Solve.Response {
        ensuringArgumentIsInstantiated(1)
        ensuringArgumentIsCallable(1)
        val solver = subSolver()
        val solutions = solver.solve(second as Struct).toList()
        val error = solutions.asSequence().filterIsInstance<Solution.Halt>().firstOrNull()
        if (error != null) {
            return replyException(error.exception.pushContext(context))
        }
        val mapped = solutions.asSequence()
            .filterIsInstance<Solution.Yes>()
            .map { first[it.substitution].freshCopy() }
        return replyWith(third mguWith List.of(mapped))
    }
}