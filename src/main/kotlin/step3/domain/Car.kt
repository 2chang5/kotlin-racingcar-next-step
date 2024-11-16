package step3.domain

class Car(private val movePolicy: MovePolicy) {
    var location = CAR_DEFAULT_LOCATION
        private set

    fun moveForward() {
        if (movePolicy.shouldMove()) location++
    }

    companion object {
        const val CAR_DEFAULT_LOCATION = 1
    }
}
