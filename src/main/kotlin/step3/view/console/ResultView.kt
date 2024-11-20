package step3.view.console

class ResultView {
    fun showResultInterface() {
        println("실행 결과")
    }

    fun showResult(carLocations: List<Int>) {
        carLocations.forEach {
            repeat(it) { print("-") }
            println()
        }
        println()
    }

    fun printErrorMessage(debugMessage: String) {
        println(debugMessage)
    }
}
