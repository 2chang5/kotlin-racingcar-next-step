package step3.view.console

import step3.controller.View

class InputView : View.Input {
    override fun getCarNames(): List<String>? {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val input = readlnOrNull()
        if (input.isNullOrEmpty()) {
            println("아무것도 입력되지 않았습니다.")
            return null
        }
        return input.split(",")
    }

    override fun getMoveCount(): Int? {
        println("시도할 횟수는 몇 회인가요?")
        val input = readlnOrNull()
        if (input.isNullOrEmpty()) {
            println("아무것도 입력되지 않았습니다.")
            return null
        }
        return input.toIntOrNull() ?: run {
            println("입력된 내용이 숫자가 아닙니다.")
            return null
        }
    }
}
