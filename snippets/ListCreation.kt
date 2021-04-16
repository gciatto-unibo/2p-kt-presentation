List.from(t1, t2, t3, last = List.empty()) // [t1, t2, t3]
// is a shortcut for
List.of(t1, t2, t3)
// which is a shortcut for
Cons.of(
    t1,
    Cons.of(
        t2,
        Cons.of(
            t3,
            Empty.list())))

List.from(t1, t2, t3, last = Var.of("T")) // [t1, t2, t3 | T]
// is a shortcut for
Cons.of(
    t1,
    Cons.of(
        t2,
        Cons.of(
            t3,
            Var.of("T"))))

Cons.singleton(t) // [t]
// is a shortcut for
Cons.of(t, List.empty())