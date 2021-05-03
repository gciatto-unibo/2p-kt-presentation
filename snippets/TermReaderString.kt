val reader = TermReader.withDefaultOperators

val terms: Sequence<Term> = reader.readTerms(
    "f(1) f(2) f(3) f(4) f(5)"
)