val l1 = Struct.of(",",
    Atom.of("a"),
    Struct.of(",",
        Atom.of("b"),
        Atom.of("c")
    )
) // ','(a, ','(b, c))

println(l1.left) // a
println(l1.right) // (b, c)

val l2 = Tuple.of(Atom.of("a"), Atom.of("b"), Atom.of("c")) // (a, b, c)

println(l1 == l2) // true
println(l2.size) // 3
l2.toSequence().forEach { println(it) } // a, b, c