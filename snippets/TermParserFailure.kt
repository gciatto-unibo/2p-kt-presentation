val parser = TermParser.withDefaultOperators
val input = "[1, 2, ]"

try {
    val list = parser.parseStruct(input) // will fail
} catch (e: ParseException) {
    println(e.message)
}