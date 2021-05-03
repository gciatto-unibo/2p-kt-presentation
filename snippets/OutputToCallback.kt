val messages = mutableListOf<String>()
val sink = OutputChannel.of<String> { messages += it }

sink.write("Appended to messages")

println(messages) // [Appended to messages]