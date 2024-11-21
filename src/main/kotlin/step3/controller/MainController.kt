package step3.controller

import step3.domain.Car
import step3.domain.RandomMovePolicy

class MainController(private val view: View) {
    fun carRacing() {
        val carCount: Int = getCarCount() ?: return
        val totalTurn: Int = getTotalTurn() ?: return

        val cars = getCars(carCount)

        proceedGame(cars, totalTurn)
    }

    private fun getCarCount(): Int? =
        kotlin.runCatching {
            view.getCarCount() ?: throw IllegalStateException("입력값이 Null이 들어왔습니다 확인해주세요")
        }.onFailure { view.printErrorMessage(it.message ?: "에러 상황입니다.") }.getOrNull()

    private fun getTotalTurn(): Int? =
        kotlin.runCatching {
            view.getMoveCount() ?: throw IllegalStateException("입력값이 Null이 들어왔습니다 확인해주세요")
        }.onFailure { view.printErrorMessage(it.message ?: "에러 상황입니다.") }.getOrNull()

    private fun getCars(carCount: Int): List<Car> {
        val movePolicy = RandomMovePolicy()
        return List(carCount) { Car(movePolicy) }
    }

    private fun proceedGame(
        cars: List<Car>,
        totalTurn: Int,
    ) {
        view.showResultInterface()
        printStepResult(cars)
        repeat(totalTurn) {
            cars.forEach { it.moveForward() }
            printStepResult(cars)
        }
    }

    private fun printStepResult(cars: List<Car>) {
        view.showResult(cars.map { it.location })
    }
}
