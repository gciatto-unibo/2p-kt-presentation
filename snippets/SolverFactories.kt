import it.unibo.tuprolog.solve.classic.ClassicSolverFactory
import it.unibo.tuprolog.solve.streams.StreamsSolverFactory

val classicFactory = ClassicSolverFactory // alternatively, Solver.classic
val streamsFactory = StreamsSolverFactory // alternatively, Solver.streams

val classicSolver: Solver = classicFactory.solverWithDefaultBuiltins()

val streamsFactory: Solver = streamsFactory.solverWithDefaultBuiltins()