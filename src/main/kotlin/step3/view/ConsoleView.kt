package step3.view

import step3.controller.View

class ConsoleView : View {
    override fun getCarCount(): Int? {
        TODO("Not yet implemented")
    }

    override fun getMoveCount(): Int? {
        TODO("Not yet implemented")
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
