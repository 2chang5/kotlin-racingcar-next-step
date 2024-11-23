package step3.domain.carTest

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.inspectors.forNone
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import step3.domain.Car
import step3.domain.MovePolicy
import step3.domain.carTest.stubMovePolicy.AlwaysMovePolicy
import step3.domain.carTest.stubMovePolicy.NeverMovePolicy
import java.lang.IllegalArgumentException

class CarTest : StringSpec({

    lateinit var dummyPolicy: MovePolicy

    beforeSpec {
        dummyPolicy =
            object : MovePolicy {
                override fun shouldMove(): Boolean = true
            }
    }

    "차량의 이름은 5글자를 초과할 수 없다." {
        listOf("여섯글자__", "일곱글자___", "여덟글자____").forNone { invalidName ->
            shouldNotThrow<IllegalArgumentException> {
                Car(movePolicy = dummyPolicy, name = invalidName)
            }
        }
    }

    "차량 이름이 1~5 글자이면 정상적으로 차량을 초기화 할 수 있다." {
        listOf("1", "2_", "3__", "4___", "5____").forAll { validName ->
            shouldNotThrow<IllegalArgumentException> {
                Car(movePolicy = dummyPolicy, name = validName)
            }
        }
    }
}) {
    private val alwaysMovePolicy = AlwaysMovePolicy()
    private val neverMovePolicy = NeverMovePolicy()

    @Test
    fun `차량이 이동하지 않는 경우 location 값이 바뀌지 않는다`() {
        val classUnderTest = Car(movePolicy = neverMovePolicy, name = "테스트차량")
        classUnderTest.moveForward()

        assertThat(classUnderTest.location).isEqualTo(Car.CAR_DEFAULT_LOCATION)
    }

    @Test
    fun `차량이 이동하는 경우 location 값이 1 커진다`() {
        val classUnderTest = Car(movePolicy = alwaysMovePolicy, name = "테스트차량")
        classUnderTest.moveForward()

        assertThat(classUnderTest.location).isEqualTo(Car.CAR_DEFAULT_LOCATION + 1)
    }

    @Test
    fun `차량이 3회 이동 성공시 location 값은 4이다`() {
        val classUnderTest = Car(movePolicy = alwaysMovePolicy, name = "테스트차량")
        val moveCount = 3
        repeat(moveCount) { classUnderTest.moveForward() }

        assertThat(classUnderTest.location).isEqualTo(Car.CAR_DEFAULT_LOCATION + moveCount)
    }
}
