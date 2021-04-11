val unificator = Unificator.default

val t1 = Struct.of("father", Atom.of("abraham"), Atom.of("isaac"))
val t2 = Struct.of("father", Atom.of("abraham"), Atom.of("isaac"))

val substitution: Substitution = unificator.mgu(t1, t2) // {}