package it.unibo.tuprolog.solve.stdlib.primitive

import it.unibo.tuprolog.core.*
import it.unibo.tuprolog.solve.ExecutionContext
import it.unibo.tuprolog.solve.exception.error.PermissionError.Operation.MODIFY
import it.unibo.tuprolog.solve.primitive.*

object Assert : UnaryPredicate.NonBacktrackable<ExecutionContext>("assert") {
    override fun Solve.Request<ExecutionContext>.computeOne(first: Term): Solve.Response {
        ensuringArgumentIsWellFormedClause(0)
        val clause: Clause = when (first) {
            is Clause -> first
            is Struct -> Fact.of(first)
            else -> return ensuringArgumentIsCallable(0).replyFail()
        }
        ensuringClauseProcedureHasPermission(clause, MODIFY)
        return replySuccess {
            addDynamicClauses(clause)
        }
    }
}