package step3.controller

import step3.domain.Car
import step3.domain.RandomMovePolicy
import kotlin.properties.Delegates

class MainController(private val view: View) {
    private var carCount by Delegates.notNull<Int>()
    private var totalTurn by Delegates.notNull<Int>()

    private lateinit var carList: List<Car>

    init {
        carRacing()
    }

    private fun carRacing() {
        start()
            .onSuccess {
                initCar()
                proceedGame()
            }
            .onFailure {
                view.printErrorMessage(it.message ?: "에러 상황입니다.")
            }
    }

    private fun start(): Result<Unit> =
        kotlin.runCatching {
            carCount = view.getCarCount() ?: throw IllegalStateException("입력값이 Null이 들어왔습니다 확인해주세요")
            totalTurn = view.getMoveCount() ?: throw IllegalStateException("입력값이 Null이 들어왔습니다 확인해주세요")
        }

    private fun initCar() {
        carList = List(carCount) { Car(RandomMovePolicy()) }
    }

    private fun proceedGame() {
        view.printResultTitle()
        printStepResult()
        repeat(totalTurn) {
            carList.forEach { it.moveForward() }
            printStepResult()
        }
    }

    private fun printStepResult() {
        view.printResult(carList.map { it.location })
    }
}
