val a = Atom.of("a") // a

println(a.value) // a
println(a.toString()) // a

val anAtom = Atom.of("an atom") // 'an atom'

println(a.value) // an atom
println(a.toString()) // 'an atom'