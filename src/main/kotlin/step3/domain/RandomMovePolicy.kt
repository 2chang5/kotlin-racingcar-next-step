package step3.domain

class RandomMovePolicy : MovePolicy {
    override fun shouldMove(): Boolean {
        val randomInt = (0..9).random()
        return randomInt >= MOVE_STANDARD
    }

    companion object {
        private const val MOVE_STANDARD = 4
    }
}
