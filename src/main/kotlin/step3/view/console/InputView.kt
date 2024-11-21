package step3.view.console

class InputView {
    fun getCarCount(): Int? {
        println("자동차 대수는 몇 대인가요?")
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

    fun getMoveCount(): Int? {
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
