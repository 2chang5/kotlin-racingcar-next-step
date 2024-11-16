package step3.domain.carTest.stubMovePolicy

import step3.domain.MovePolicy

class AlwaysMovePolicy : MovePolicy {
    override fun shouldMove(): Boolean = true
}
