package step2.domain

import kotlin.properties.Delegates

class BinaryCalculator(expression: List<String>) {
    private val innerExpression = expression.toMutableList()

    private var accumulator: Double = innerExpression.removeFirst().toDouble()

    private var operand by Delegates.notNull<Double>()

    private lateinit var currentOperation: String

    fun calculate(): Double {
        initializeValue()
        val operationClass = getOperationOrThrow()
        accumulator = operationClass.execute(accumulator, operand)
        return if (innerExpression.isEmpty()) accumulator else calculate()
    }

    private fun getOperationOrThrow(): Operation =
        Operation.getOperationByNotation(currentOperation) ?: throw IllegalStateException(WRONG_OPERATION_ERROR_MESSAGE)

    private fun initializeValue() {
        currentOperation = innerExpression.removeFirst()
        operand = innerExpression.removeFirst().toDouble()
    }

    companion object {
        private const val WRONG_OPERATION_ERROR_MESSAGE = "잘못된 연산자가 사용되었습니다."
    }
}
