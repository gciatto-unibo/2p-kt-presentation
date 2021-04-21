interface TermFormatter : Formatter<Term>, TermVisitor<String> {

    override fun format(term: Term): String = term.accept(this)
    
}