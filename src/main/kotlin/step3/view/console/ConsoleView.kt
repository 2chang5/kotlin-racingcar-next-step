package step3.view.console

import step3.controller.View

class ConsoleView(
    private val inputView: InputView = InputView(),
    private val resultView: ResultView = ResultView(),
) : View {
    override fun getCarCount(): Int? = inputView.getCarCount()

    override fun getMoveCount(): Int? = inputView.getMoveCount()

    override fun showResultInterface() = resultView.showResultInterface()

    override fun showResult(carLocations: List<Int>) = resultView.showResult(carLocations)

    override fun printErrorMessage(debugMessage: String) = resultView.printErrorMessage(debugMessage)
}
