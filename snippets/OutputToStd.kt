val sink1 = OutputChannel.stdOut<String>()
val sink2 = OutputChannel.stdErr<String>()

sink1.write("Printed on stdout\n")
sink2.write("Printed on stderr\n")