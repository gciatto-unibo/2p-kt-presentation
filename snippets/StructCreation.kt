Struct.template("f", 2)
// is a shortcut for
Struct.of("f", Var.anonymous(), Var.anonymous())

Struct.fold("f", arrayOf(Atom.of("a"), Atom.of("b"), Atom.of("c")), null)
// is a shortcut for
Struct.of("f", 
    Atom.of("a"),
    Struct.of("f", 
        Atom.of("b"),
        Atom.of("c")))

Struct.fold("f", arrayOf(Atom.of("a"), Atom.of("b"), Atom.of("c")), Var.of("Z"))
// is a shortcut for
Struct.of("f", 
    Atom.of("a"),
    Struct.of("f", 
        Atom.of("b"),
        Struct.of("f", 
            Atom.of("c"),
            Var.of("Z"))))