val unificator = Unificator.default

val t1 = Struct.of("father", Atom.of("abraham"), Atom.of("isaac"))
val t2 = Struct.of("father", Atom.of("isaac"), Atom.of("abraham"))

val substitution: Substitution = unificator.mgu(t1, t2)
val isFail: Boolean = substitution is Substitution.Fail // true
val isFailed: Boolean = substitution.isFailed // true
val match: Boolean = unificator.match(t1, t2) // false
val result: Term? = unificator.unify(t1, t2) // null