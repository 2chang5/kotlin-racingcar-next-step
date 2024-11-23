package step3.view.console

import step3.controller.View
import step3.domain.Car

class ConsoleView(
    private val inputView: InputView = InputView(),
    private val resultView: ResultView = ResultView(),
) : View {
    override fun getCarNames(): List<String>? = inputView.getCarNames()

    override fun getMoveCount(): Int? = inputView.getMoveCount()

    override fun showResultInterface() = resultView.showResultInterface()

    override fun showResult(cars: List<Car>) = resultView.showResult(cars)

    override fun showWinner(winners: List<String>) = resultView.showWinner(winners)

    override fun printErrorMessage(debugMessage: String) = resultView.printErrorMessage(debugMessage)
}
