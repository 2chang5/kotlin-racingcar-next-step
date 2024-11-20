package step3

import step3.controller.MainController
import step3.view.console.ConsoleView

fun main() {
    val controller = MainController(ConsoleView())

    controller.carRacing()
}
