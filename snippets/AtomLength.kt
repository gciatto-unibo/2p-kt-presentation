package it.unibo.tuprolog.solve.stdlib.primitive

import it.unibo.tuprolog.core.*
import it.unibo.tuprolog.solve.ExecutionContext
import it.unibo.tuprolog.solve.primitive.*
import it.unibo.tuprolog.unify.Unificator.Companion.mguWith

object AtomLength : BinaryRelation.Functional<ExecutionContext>("atom_length") {
    override fun Solve.Request<ExecutionContext>.computeOneSubstitution(first: Term, second: Term): Substitution =
        when {
            first is Var -> {
                ensuringAllArgumentsAreInstantiated()
                Substitution.failed()
            }
            second is Var -> {
                ensuringArgumentIsAtom(0)
                val atomLength = (first as Atom).value.length
                Substitution.of(second, Integer.of(atomLength))
            }
            else -> {
                ensuringArgumentIsAtom(0)
                ensuringArgumentIsNonNegativeInteger(1)
                val atomLength = Integer.of((first as Atom).value.length)
                atomLength mguWith second
            }
        }
}