package step2.inputValidator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import step2.inputValidator.BasicValidators.validEmptyString
import step2.inputValidator.BasicValidators.validNull
import step2.inputValidator.InputValidateException.InputIsEmptyException
import step2.inputValidator.InputValidateException.InputIsNullException

class BasicValidatorsTest {
    @Test
    fun `계산식이 null로 들어올시 Result 실패 상황(InputIsNullException) 을 반환한다`() {
        val input: List<String>? = null

        assertThat(input.validNull().isFailure).isTrue()
        assertThat(input.validNull().exceptionOrNull() is InputIsNullException).isTrue()
    }

    @Test
    fun `계산식이 null이 아닐시 Result 성공 상황(입력된 값) 을 반환한다`() {
        val input: List<String> = "1 + 1".split(" ")

        assertThat(input.validNull().isSuccess).isTrue()
        assertThat(input.validNull().getOrNull() == "1 + 1".split(" ")).isTrue()
    }

    @Test
    fun `계산식이 빈스트링으로 들어올시 Result 실패 상황(InputIsEmptyException) 을 반환한다`() {
        val input: List<String> = "     ".split(" ")

        assertThat(input.validEmptyString().isFailure).isTrue()
        assertThat(input.validEmptyString().exceptionOrNull() is InputIsEmptyException).isTrue()
    }

    @Test
    fun `계산식이 빈스트링이 아닐시 Result 성공 상황(입력된 값) 을 반환한다`() {
        val input: List<String> = "1 + 1".split(" ")

        assertThat(input.validEmptyString().isSuccess).isTrue()
        assertThat(input.validEmptyString().getOrNull() == "1 + 1".split(" ")).isTrue()
    }
}
