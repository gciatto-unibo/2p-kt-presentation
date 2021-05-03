val source = InputChannel.stdIn()
println(source.read()) // block until a line is is prompted, 
    // then prints the first char
    // may print null in testing