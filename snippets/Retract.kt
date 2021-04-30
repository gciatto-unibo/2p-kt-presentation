package it.unibo.tuprolog.solve.stdlib.primitive

import it.unibo.tuprolog.core.*
import it.unibo.tuprolog.solve.ExecutionContext
import it.unibo.tuprolog.solve.exception.error.PermissionError
import it.unibo.tuprolog.solve.primitive.*
import it.unibo.tuprolog.unify.Unificator.Companion.mguWith
import it.unibo.tuprolog.utils.buffered

object Retract : UnaryPredicate<ExecutionContext>("retract") {
    override fun Solve.Request<ExecutionContext>.computeAll(first: Term): Sequence<Solve.Response> {
        ensuringArgumentIsWellFormedClause(0)
        val clause: Clause = when (first) {
            is Clause -> first
            is Struct -> Rule.of(first, Var.anonymous())
            else -> return sequenceOf(ensuringArgumentIsCallable(0).replyFail())
        }
        ensuringClauseProcedureHasPermission(clause, PermissionError.Operation.MODIFY)
        return context.dynamicKb[clause].buffered().map {
            val substitution = when (first) {
                is Clause -> (first mguWith it) as Substitution.Unifier
                else -> (first mguWith it.head!!) as Substitution.Unifier
            }
            replySuccess(substitution) {
                removeDynamicClauses(it)
            }
        }
    }
}