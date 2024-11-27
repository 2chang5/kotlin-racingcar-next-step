package step3.domain

class Car(
    private val movePolicy: MovePolicy,
    location: Int = CAR_DEFAULT_LOCATION,
    val name: String,
) {
    var location = location
        private set

    init {
        require(name.length <= 5) { CAR_NAME_LENGTH_ERROR_MESSAGE }
    }

    fun moveForward() {
        if (movePolicy.shouldMove()) location++
    }

    companion object {
        const val CAR_DEFAULT_LOCATION = 1
        private const val CAR_NAME_LENGTH_ERROR_MESSAGE = "차량이름은 5글자를 초과할 수 없습니다."
    }
}
