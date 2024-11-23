package step3.controller

import step3.domain.Car
import step3.domain.Cars
import step3.domain.RandomMovePolicy

class MainController(private val view: View) {
    fun carRacing() {
        val carNames: List<String> = getCarNames().getOrNull() ?: return
        val totalTurn: Int = getTotalTurn().getOrNull() ?: return

        val cars = getCars(carNames)

        proceedGame(cars, totalTurn)
    }

    private fun getCarNames(): Result<List<String>> =
        kotlin.runCatching {
            view.getCarNames() ?: throw IllegalStateException("입력값이 Null이 들어왔습니다 확인해주세요")
        }.onFailure { view.printErrorMessage(it.message ?: "에러 상황입니다.") }

    private fun getTotalTurn(): Result<Int> =
        kotlin.runCatching {
            view.getMoveCount() ?: throw IllegalStateException("입력값이 Null이 들어왔습니다 확인해주세요")
        }.onFailure { view.printErrorMessage(it.message ?: "에러 상황입니다.") }

    private fun getCars(carNames: List<String>): Cars {
        val movePolicy = RandomMovePolicy()
        return Cars(carNames.map { Car(movePolicy = movePolicy, name = it) })
    }

    private fun proceedGame(
        cars: Cars,
        totalTurn: Int,
    ) {
        view.showResultInterface()
        view.showResult(cars.value)
        repeat(totalTurn) {
            cars.proceedTurn()
            view.showResult(cars.value)
        }
        view.showWinner(cars.getWinner())
    }
}
