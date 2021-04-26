val unificator = object : AbstractUnificator() {
    override fun checkTermsEquality(x: Term, y: Term): Boolean = when {
        x is Integer && y is Integer ->
            x.value.absoluteValue.compareTo(y.value.absoluteValue) == 0
        x is Numeric && y is Numeric ->
            x.decimalValue.absoluteValue.compareTo(y.decimalValue.absoluteValue) == 0
        else -> x == y
    }
}

val t1 = Struct.of("f", Integer.of(1)) // f(1)
val t2 = Struct.of("f", Integer.of(-1)) // f(-1)

val match = unificator.match(t1, t2) // true
val result = unificator.unify(t1, t2) // f(1)