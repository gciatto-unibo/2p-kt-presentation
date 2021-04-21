val X = Var.of("X")

println(X.isAnonymous) // false
println(X.name) // X
println(X.completeName) // X_1
println(X.id) // 1

val whatever = Var.anonymous()

println(whatever.isAnonymous) // true
println(whatever.name) // _
println(whatever.completeName) // __2
println(whatever.id) // 2