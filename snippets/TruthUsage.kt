val t = Truth.TRUE
val f1 = Truth.FALSE
val f2 = Truth.FAIL

println(t.value) // true
println(f1.value) // false
println(f2.value) // fail

println(t.isTrue + " " + t.isFail) // true false
println(f1.isTrue + " " + f1.isFail) // false true
println(f2.isTrue + " " + f2.isFail) // false true