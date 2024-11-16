package step3.domain.carTest

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import step3.domain.Car
import step3.domain.carTest.stubMovePolicy.AlwaysMovePolicy
import step3.domain.carTest.stubMovePolicy.NeverMovePolicy

class CarTest {
    private val alwaysMovePolicy = AlwaysMovePolicy()
    private val neverMovePolicy = NeverMovePolicy()

    @Test
    fun `차량이 이동하지 않는 경우 location 값이 바뀌지 않는다`() {
        val classUnderTest = Car(neverMovePolicy)
        classUnderTest.moveForward()

        assertThat(classUnderTest.location).isEqualTo(Car.CAR_DEFAULT_LOCATION)
    }

    @Test
    fun `차량이 이동하는 경우 location 값이 1 커진다`() {
        val classUnderTest = Car(alwaysMovePolicy)
        classUnderTest.moveForward()

        assertThat(classUnderTest.location).isEqualTo(Car.CAR_DEFAULT_LOCATION + 1)
    }

    @Test
    fun `차량이 3회 이동 성공시 location 값은 4이다`() {
        val classUnderTest = Car(alwaysMovePolicy)
        val moveCount = 3
        repeat(moveCount) { classUnderTest.moveForward() }

        assertThat(classUnderTest.location).isEqualTo(Car.CAR_DEFAULT_LOCATION + moveCount)
    }
}
