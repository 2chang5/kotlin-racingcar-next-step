package step3.controller

import step3.domain.Car

interface View {
    fun getCarNames(): List<String>?

    fun getMoveCount(): Int?

    fun showResultInterface()

    fun showResult(cars: List<Car>)

    fun showWinner(winners: List<String>)

    fun printErrorMessage(debugMessage: String)
}
