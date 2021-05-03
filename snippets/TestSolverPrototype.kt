import kotlin.test.Test

class GeneralTestSuite(private val solverFactory: SolverFactory) {
    fun testCase() {
        val solver = solverFactory.solverOf()
        // assertions here
    }
}

import it.unibo.tuprolog.solve.classic.ClassicSolverFactory
class ClassicTestSuite : GeneralTestClass(ClassicSolverFactory) {
    @Test
    override fun testCase() = super.testCase()
}

import it.unibo.tuprolog.solve.classic.StreamsSolverFactory
class StreamsTestSuite : GeneralTestClass(StreamsSolverFactory) {
    @Test
    override fun testCase() = super.testCase()
}