val l1 = Cons.of(
    Atom.of("a"),
    Cons.of(
        Atom.of("b"),
        Cons.of(Atom.of("c"), Empty.list())
    )
) // .(a, .(b, .(c, [])))

println(l1.head) // a
println(l1.tail) // [b, c]

val l2 = List.of(Atom.of("a"), Atom.of("b"), Atom.of("c")) // [a, b, c]

println(l1 == l2) // true
println(l1.size) // 3
l2.unfoldedSequence.forEach { println(it) } // a, b, c, []
l2.toSequence().forEach { println(it) } // a, b, c

val l3 = List.from(Atom.of("a"), Atom.of("b"), last=Var.of("T")) // [a, b | T]
l3.unfoldedSequence.forEach { println(it) } // a, b, T
l3.toSequence().forEach { println(it) } // a, b, T