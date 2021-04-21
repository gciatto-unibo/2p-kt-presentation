val a: Term = Atom.of("a") // a
val one: Term = Integer.of(1) // 1

val X: Term = Var.of("X") // X
val Y: Term = Var.of("Y") // Y

val f: Term = Struct.of("f", X, a, one, Y) // f(X, a, 1, Y)
val g: Term = Struct.of("g", a, one) // g(a, 1)

println(f.isGround) // false
println(g.isGround) // true

println(f.variables.toList()) // [X, Y]
println(g.variables.toList()) // []