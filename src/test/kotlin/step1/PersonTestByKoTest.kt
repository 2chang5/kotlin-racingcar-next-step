package step1

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe

class PersonTestByKoTest : StringSpec({

    "코틀린은 이름 붙인 인자를 사용할 수 있다" {
        val classUnderTest = Person(name = "이창환", age = 29, nickname = "멧돼지")

        classUnderTest.name shouldBe "이창환"
        classUnderTest.age shouldBe 29
        classUnderTest.nickname shouldBe "멧돼지"
    }

    "코틀린은 Nullable한 타입을 사용 가능하다" {
        val classUnderTest = Person(name = "이창환", age = 29, nickname = null)

        classUnderTest.nickname.shouldBeNull()
    }

    "코틀린은 기본인자가 사용 가능하다" {
        val classUnderTest = Person(name = "이창환", age = 29)

        classUnderTest.nickname shouldBe "이창환"
    }

    "데이터 클래스는 기본적으로 값을 통해 동등성을 비교하도록 동작한다" {
        val mainClassUnderTest = Person(name = "이창환", age = 29, nickname = "멧돼지")
        val comparisonClassUnderTest = Person(name = "이창환", age = 29, nickname = "멧돼지")

        mainClassUnderTest shouldBe comparisonClassUnderTest
    }
})
