package step3.view

import step3.controller.View
import step3.view.validator.InputValidateException
import step3.view.validator.InputValidateException.InputIsEmptyException
import step3.view.validator.InputValidateException.InputIsNullException
import step3.view.validator.InputValidateException.NonNumericException
import step3.view.validator.castToLastValidatorReturnType
import step3.view.validator.concrete.EmptyStringValidator
import step3.view.validator.concrete.NullValidator
import step3.view.validator.concrete.NumberValidator

class ConsoleView : View {
    override fun getCarCount(): Int? {
        println("자동차 대수는 몇 대인가요?")
        val input = readlnOrNull()
        NullValidator()
            .setNext(EmptyStringValidator())
            .setNext(NumberValidator()).validate(input)
            .onSuccess { return castToLastValidatorReturnType(it, NumberValidator()) }
            .onFailure {
                printWrongInputMessage(it)
                return null
            }
        return null
    }

    override fun getMoveCount(): Int? {
        println("시도할 횟수는 몇 회인가요?")
        val input = readlnOrNull()
        NullValidator()
            .setNext(EmptyStringValidator())
            .setNext(NumberValidator()).validate(input)
            .onSuccess { return castToLastValidatorReturnType(it, NumberValidator()) }
            .onFailure {
                printWrongInputMessage(it)
                return null
            }
        return null
    }

    private fun printWrongInputMessage(reason: Throwable) {
        println(getErrorMessage(reason))
    }

    private fun getErrorMessage(reason: Throwable): String {
        if (reason !is InputValidateException) return "관리자에게 문의주세요 (가상의 에러코드)"
        return when (reason) {
            is InputIsNullException,
            is InputIsEmptyException,
            -> "아무것도 입력되지 않았습니다."
            is NonNumericException,
            -> "입력된 내용이 숫자가 아닙니다."
        }
    }

    override fun printResultTitle() {
        println("실행 결과")
    }

    override fun printResult(carLocations: List<Int>) {
        carLocations.forEach {
            repeat(it) { print("-") }
            println()
        }
        println()
    }
}
