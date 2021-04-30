object AtomLength : BinaryRelation.Functional<ExecutionContext>("atom_length") {
    override fun Solve.Request<ExecutionContext>.computeOneSubstitution(
        x: Term, 
        y: Term
    ): Substitution = when {
        x is Var -> {
            ensuringAllArgumentsAreInstantiated()
            Substitution.failed()
        }
        y is Var -> {
            ensuringArgumentIsAtom(0)
            val atomLength = (x as Atom).value.length
            Substitution.of(y, Integer.of(atomLength))
        }
        else -> {
            ensuringArgumentIsAtom(0)
            ensuringArgumentIsNonNegativeInteger(1)
            val atomLength = Integer.of((x as Atom).value.length)
            atomLength mguWith y
        }
    }
}