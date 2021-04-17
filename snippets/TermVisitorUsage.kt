class MyVisitor : TermVisitor<String> {
    override fun defaultValue(term: Term): String = "?"

    override fun visitInteger(term: Integer): String = "integer"
    override fun visitStruct(term: Struct): String = "struct"
    override fun visitAtom(term: Atom): String = "atom"
}

val visitor = MyVisitor()

println(Atom.of("a").accept(visitor)) // "atom"
println(Integer.ONE.accept(visitor)) // "integer"
println(Struct.of("f", Integer.ONE).accept(visitor)) // "struct"
println(List.empty().accept(visitor)) // ?
println(Real.ONE.accept(visitor)) // ?