val arg1 = Numeric.of(1) // this actually creates an Integer
val arg2 = Numeric.of(2.3) // this actually creates a Real
val arg3 = Atom.of("[]") // this actually creates an EmptyList
val struct = Struct.of(".", arg1, Struct.of(".", arg2, arg3))
val list = struct as Cons // struct is actually a Cons
println(list) // [1, 2.3]
println(list.isWellFormed) // true, as the last item is EmptyList