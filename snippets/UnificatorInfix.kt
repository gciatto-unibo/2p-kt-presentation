import it.unibo.tuprolog.unify.Unificator.Companion.matches
import it.unibo.tuprolog.unify.Unificator.Companion.mguWith
import it.unibo.tuprolog.unify.Unificator.Companion.unifyWith

val t1 = Struct.of("father", Atom.of("abraham"), Atom.of("isaac"))
val t2 = Struct.of("father", Var.of("X"), Atom.of("isaac"))

val substitution: Substitution = t1 mguWith t2 // {X_0=abraham}
val match: Boolean = t1 matches t2 // true
val result: Term? = t1 unifyWith t2 // father(abraham, isaac)