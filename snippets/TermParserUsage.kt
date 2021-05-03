val parser = TermParser.withDefaultOperators

val atom: Atom = parser.parseAtom("a")
val list: Struct = parser.parseStruct("[1, 2, 3]")
val clause: Clause = parser.parseClause(
    "grandfather(X, Y) :- father(X, Z), father(Z, Y)."
)