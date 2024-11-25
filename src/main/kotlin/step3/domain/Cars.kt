package step3.domain

class Cars(val value: List<Car>) {
    constructor(vararg cars: Car) : this(cars.toList())

    fun proceedTurn() {
        value.forEach { it.moveForward() }
    }

    fun getWinner(): List<String> {
        val winnerLocation = value.maxOf { it.location }
        return value.filter { it.location == winnerLocation }.map { it.name }
    }
}
