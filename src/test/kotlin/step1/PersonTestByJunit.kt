package step1

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test

class PersonTestByJunit {
    @Test
    fun `코틀린은 이름 붙인 인자를 사용할 수 있다`() {
        val classUnderTest = Person(name = "이창환", age = 29, nickname = "멧돼지")

        assertThat(classUnderTest.name).isEqualTo("이창환")
        assertThat(classUnderTest.age).isEqualTo(29)
        assertThat(classUnderTest.nickname).isEqualTo("멧돼지")
    }

    @Test
    fun `코틀린은 Nullable한 타입을 사용 가능하다`() {
        val classUnderTest = Person(name = "이창환", age = 29, nickname = null)

        assertThat(classUnderTest.nickname).isNull()
    }

    @Test
    fun `코틀린은 기본인자가 사용 가능하다`() {
        val classUnderTest = Person(name = "이창환", age = 29)

        assertThat(classUnderTest.nickname).isEqualTo("이창환")
    }

    @Test
    fun `데이터 클래스는 기본적으로 값을 통해 동등성을 비교하도록 동작한다`() {
        val mainClassUnderTest = Person(name = "이창환", age = 29, "멧돼지")
        val comparisonClassUnderTest = Person(name = "이창환", age = 29, "멧돼지")

        assertThat(mainClassUnderTest).isEqualTo(comparisonClassUnderTest)
    }
}
