Rule.of(
    Struct.of("anchestor", Var.of("X"), Var.of("Y")),
    Struct.of("parent", Var.of("X"), Var.of("Z")),
    Struct.of("parent", Var.of("Z"), Var.of("Y"))
) // anchestor(X_1, Y_2) :- parent(X_3, Z_4), parent(Z_5, Y_6).

// is logically equivalent to

Rule.of(
    Struct.of("anchestor", Var.of("A"), Var.of("B")),
    Struct.of("parent", Var.of("C"), Var.of("D")),
    Struct.of("parent", Var.of("E"), Var.of("F"))
) // anchestor(A, B) :- parent(C, D), parent(E, F).

// THIS IS WRONG. Correct way below:

val X = Var.of("X"); val Y = Var.of("Y"); val Z = Var.of("Z")

Rule.of(
    Struct.of("anchestor", X, Y),
    Struct.of("parent", X, Z),
    Struct.of("parent", Z, Y)
) // anchestor(X_1, Y_2) :- parent(X_1, Z_3), parent(Z_3, Y_2).