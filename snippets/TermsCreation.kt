val atom1 = Atom.of("a") // a
val atom2 = Atom.of("a b") // 'a b'
val integer = Integer.of(1) // 1
val real = Real.of(2.3) // 2.3
val X = Var.of("X") // X_1
val struct = Struct.of("f", atom1, integer, X) // f(a, 1, X_1)