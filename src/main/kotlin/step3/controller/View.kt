package step3.controller

interface View {
    fun getCarCount(): Int?

    fun getMoveCount(): Int?

    fun printResultTitle()

    fun printResult(carLocations: List<Int>)
}
