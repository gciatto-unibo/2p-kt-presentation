var i = 0
val source = InputChannel.of { ('a' + i++).toString() }
println(source.read()) // a
println(source.read()) // b
println(source.read()) // c