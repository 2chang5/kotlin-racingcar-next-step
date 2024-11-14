package step2.consoleView

import step2.contorller.ConsoleView

class DefaultConsoleView : ConsoleView {
    override fun getMathExpression(): List<String>? {
        println("안녕하세요 계산요정 멧돼지입니다🐗. 수식을 입력해주세요❤️")
        val input = readLine()?.split(" ")

        return input
    }

    private fun printWrongExpression() {
    }

    override fun printConclusion(result: Result<Int>) {
        result.onSuccess(::printSuccessConclusion).onFailure(::printFailureConclusion)
    }

    private fun printSuccessConclusion(conclusion: Int) {
        println("결과는 뾰로롱 $conclusion 입니다.")
    }

    private fun printFailureConclusion(error: Throwable) {
        when (error) {
        }
    }
}
