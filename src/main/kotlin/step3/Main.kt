package step3

import step3.controller.MainController
import step3.view.console.InputView
import step3.view.console.ResultView

fun main() {
    val controller = MainController(InputView(), ResultView())

    controller.carRacing()
}
