package step2.consoleView

import step2.consoleView.inputValidator.FourBasicOperationsValidatorFacade
import step2.consoleView.inputValidator.InputValidateException
import step2.contorller.View

class ConsoleView : View {
    override fun getMathExpression(): List<String>? {
        println("안녕하세요 계산요정 멧돼지입니다🐗. 수식을 입력해주세요❤️")
        val input = readlnOrNull()?.split(" ")
        FourBasicOperationsValidatorFacade.validate(input)
            .onSuccess { return it }
            .onFailure {
                printWrongExpression(it)
                return null
            }

        return null
    }

    private fun printWrongExpression(reason: Throwable) {
        println(getErrorMessage(reason))
    }

    private fun getErrorMessage(reason: Throwable): String {
        if (reason !is InputValidateException) return "관리자에게 문의주세요 (가상의 에러코드)"
        return when (reason) {
            is InputValidateException.InputIsNullException,
            is InputValidateException.InputIsEmptyException,
            -> "수식으로 아무것도 안넣으셨네요 당신은 장난꾸러기 히히히"
            is InputValidateException.NonNumericStartOrEndException,
            is InputValidateException.NonNumericAtExpectedPositionException,
            -> "숫자가 들어가야할 자리에 이상한게 들어갔어요 확인해보세요"
            is InputValidateException.InvalidOperatorException,
            -> "사칙연산을 제외한 연산자가 들어왔어요 확인해보세요"
        }
    }

    override fun printConclusion(result: Result<Double>) {
        result.onSuccess(::printSuccessConclusion).onFailure(::printFailureConclusion)
    }

    private fun printSuccessConclusion(conclusion: Double) {
        println("결과는 뾰로롱 $conclusion 입니다.")
    }

    private fun printFailureConclusion(error: Throwable) {
        println("디버깅용임 유저한테 들키면 안됨" + error.message)
    }
}
