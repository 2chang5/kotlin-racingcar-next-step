package step2.contorller

import step2.domain.BinaryCalculator

class MainController(private val view: View) {
    private lateinit var mathExpression: List<String>

    init {
        start()
        val conclusion = calculate()
        printConclusion(conclusion)
    }

    private fun start() {
        mathExpression = view.getMathExpression() ?: return
    }

    private fun calculate(): Result<Double> = kotlin.runCatching { BinaryCalculator(mathExpression).calculate() }

    private fun printConclusion(conclusion: Result<Double>) {
        view.printConclusion(conclusion)
    }
}
