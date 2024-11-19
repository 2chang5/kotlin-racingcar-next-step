package step3

import step3.controller.MainController
import step3.view.ConsoleView

fun main() {
    val controller = MainController(ConsoleView())

    controller.carRacing()
}
