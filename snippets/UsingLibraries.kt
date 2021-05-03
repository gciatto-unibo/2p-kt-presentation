import it.unibo.tuprolog.solve.classic.stdlib.DefaultBuiltins
import it.unibo.tuprolog.solve.libs.io.IOLib
import it.unibo.tuprolog.solve.libs.oop.OOPLib

val solver = Solver.classic.solverOf(
    libraries = Libraries.of(DefaultBuiltins, IOLib, OOPLib)
)

println(solver.libraries.keys) // [prolog.lang, prolog.io, prolog.oop]