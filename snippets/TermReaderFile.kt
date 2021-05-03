val reader = TermReader.withDefaultOperators
val inputStream = 
    this::class.java.classLoader.getResourceAsStream("test.pl")!!

val terms = reader.readTerms(inputStream)