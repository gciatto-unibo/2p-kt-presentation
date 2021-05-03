val reader = TermReader.withDefaultOperators
val input = "f(1) f(2) f(3 f(4) f(5)" // malformed input

try {
    val terms = reader.readTerms(input)
    val count = terms.count() // parsing fails here due to lazy evaluation
} catch (e: ParseException) {
    println(e.message)
}