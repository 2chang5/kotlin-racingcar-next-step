package step3.view.console

import step3.domain.Car

class ResultView {
    fun showResultInterface() {
        println("실행 결과")
    }

    fun showResult(cars: List<Car>) {
        cars.forEach {
            print("${it.name} : ")
            repeat(it.location) { print("-") }
            println()
        }
        println()
    }

    fun showWinner(winners: List<String>) {
        val winnersToString = winners.joinToString(separator = ", ")
        print("${winnersToString}가 최종 우승했습니다.")
    }

    fun printErrorMessage(debugMessage: String) {
        println(debugMessage)
    }
}
