package step3.controller

interface View {
    fun getCarCount(): Int?

    fun getMoveCount(): Int?

    fun showResultInterface()

    fun showResult(carLocations: List<Int>)

    fun printErrorMessage(debugMessage: String)
}
