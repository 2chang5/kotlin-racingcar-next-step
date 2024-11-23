package step3.controller

import step3.domain.Car

interface View {
    interface Input {
        fun getCarNames(): List<String>?

        fun getMoveCount(): Int?
    }

    interface Output {
        fun showResultInterface()

        fun showResult(cars: List<Car>)

        fun showWinner(winners: List<String>)

        fun printErrorMessage(debugMessage: String)
    }
}
