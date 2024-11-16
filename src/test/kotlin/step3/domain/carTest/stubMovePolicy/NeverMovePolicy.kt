package step3.domain.carTest.stubMovePolicy

import step3.domain.MovePolicy

class NeverMovePolicy : MovePolicy {
    override fun shouldMove(): Boolean = false
}
