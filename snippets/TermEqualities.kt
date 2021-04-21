val t1 = Struct.of(Integer.ONE, Atom.of("a"), Var.of("X")) 
      // f(1, a, X_1)
val t2 = Struct.of(Integer.ONE, Atom.of("a"), Var.of("X")) 
      // f(1, a, X_2)
val t3 = Struct.of(Real.ONE, Atom.of("a"), Var.of("Y"))    
      // f(1.0, a, Y_3)

println(t1.equals(t2)) // false
println(t1 == t1) // alias for the above
println(t1.equals(t2, useVarCompleteName = true)) // false 
println(t1.equals(t2, useVarCompleteName = false)) // true
println(t1.structurallyEquals(t2)) // true