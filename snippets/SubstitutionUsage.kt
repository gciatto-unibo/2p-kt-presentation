val X = Var.of("X"); val Y = Var.of("Y"); val Z = Var.of("Z")

val u1 = Substitution.unifier(X to Integer.of(1), Y to Atom.of("a")) // {X=1, Y=a}
val u2 = Substitution.unifier(Z to Struct.of(Integer.of(1), Atom.of("a"))) // {Z=f(1, a)}
val f = Substitution.failed();

val s1: Substitution = u1 + u2 // {X=1, Y=a, Z=f(1, a)}

println(s1 is Substitution.Unifier) // true
println(s1.isSuccess) // true
println(s1[X]) // 1
println(s1.get(Y)) // a
println(s1.getByName("Z")) // f(1, a)

println(s1 - Y) // {X=1, Z=f(1, a)}
println(s1.filter { it.name == "X" }) // {X=1}

val s2: Substitution = u1 + f
println(s2 is Substitution.Fail) // true

val s3 = u1 + Substitution.of(X to Integer.of(2)) // {X=1, Y=a} + {X=2}
println(s3 is Substitution.Fail) // true