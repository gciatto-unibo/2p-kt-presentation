val parser = ClausesParser.withDefaultOperators
val serializer = TheorySerializer.of(MimeType.Json)
val deserializer = TheoryDeserializer.of(MimeType.Json)

val theory = parser.parseTheory("""
    grandfather(X, Y) :- father(X, Z), father(Z, Y).
    father(abraham, isaac).
    father(isaac, jacob).
""".trimIndent())

val serialized: String = serializer.serialize(theory)

val deserialized: Theory = deserializer.deserialize(serialized)