val parser = ClausesParser.withDefaultOperators
val input = """
    father(abraham, isaac)
    father(isaac, jacob)
""".trimIndent() // no full stops after each clause

try {
    val theory = parser.parseTheory(input) // will fail
} catch (e: ParseException) {
    println(e.message)
}
