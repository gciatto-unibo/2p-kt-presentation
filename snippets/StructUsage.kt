val a = Atom.of("a") // a
val one = Integer.of(1) // 1

val X = Var.of("X") // X
val Y = Var.of("Y") // Y

val ga1 = Struct.of("g", a, one) // g(a, 1)

println(ga1.functor) // g
println(ga1.arity) // 2
println(ga1.argsList) // [a, 1]
println(ga1.toString()) // g(a, 1)

val Fa1 = ga1.setFunctor("F") // 'F'(a, 1)
val FXa1 = fa1.addFirst(X) // 'F'(X, a, 1)
val FXa1Y = fa1.addLast(Y) // 'F'(X, a, 1, Y)

println(FXa1Y.functor) // F
println(FXa1Y.arity) // 4
println(FXa1Y.argsList) // [X_1, a, 1, Y_2]
println(FXa1Y.toString()) // 'F'(X_1, a, 1, Y_2)