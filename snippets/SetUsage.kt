val l1 = Struct.of("{}",
    Tuple.of(Atom.of("a"), Atom.of("b"), Atom.of("c"))
) // '{}'( ','(a, ','(b, c)) )

val l2 = Set.of(Atom.of("a"), Atom.of("b"), Atom.of("c")) // {a, b, c}

println(l1 == l2) // true
println(l2.size) // 3
l2.toSequence().forEach { println(it) } // a, b, c