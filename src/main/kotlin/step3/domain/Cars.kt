package step3.domain

class Cars(cars: List<Car>) {
    val value: List<Car> = cars.toList()

    constructor(vararg cars: Car) : this(cars.toList())

    fun proceedTurn() {
        value.forEach { it.moveForward() }
    }

    fun getWinner(): List<String> {
        val winnerLocation = value.maxOf { it.location }
        return value.filter { it.location == winnerLocation }.map { it.name }
    }
}
