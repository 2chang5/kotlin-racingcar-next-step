package step2.inputValidator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import step2.inputValidator.FourBasicOperationsValidators.validStartsAndEndsWithNumber
import step2.inputValidator.FourBasicOperationsValidators.validateNumberInExpression
import step2.inputValidator.FourBasicOperationsValidators.validateOperatorInExpression
import step2.inputValidator.InputValidateException.InvalidOperatorException
import step2.inputValidator.InputValidateException.NonNumericAtExpectedPositionException

class FourBasicOperationsValidatorsTest {
    @Test
    fun `계산식이 숫자로 시작하지 않을 경우 Result 실패 상황(NonNumericStartOrEndException) 을 반환한다`() {
        val input: List<String> = "d + 1".split(" ")

        assertThat(input.validStartsAndEndsWithNumber().isFailure).isTrue()
        assertThat(input.validStartsAndEndsWithNumber().exceptionOrNull() is InputValidateException.NonNumericStartOrEndException).isTrue()
    }

    @Test
    fun `계산식이 숫자로 끝나지 않을 경우 Result 실패 상황(NonNumericStartOrEndException) 을 반환한다`() {
        val input: List<String> = "1 + d".split(" ")

        assertThat(input.validStartsAndEndsWithNumber().isFailure).isTrue()
        assertThat(input.validStartsAndEndsWithNumber().exceptionOrNull() is InputValidateException.NonNumericStartOrEndException).isTrue()
    }

    @Test
    fun `계산식 시작과 끝이 숫자로 끝날시 Result 성공 상황(입력된 값) 을 반환한다`() {
        val input: List<String> = "1 + 1".split(" ")

        assertThat(input.validStartsAndEndsWithNumber().isSuccess).isTrue()
        assertThat(input.validStartsAndEndsWithNumber().getOrNull() == "1 + 1".split(" ")).isTrue()
    }

    @Test
    fun `계산식 자릿수에서(1부터시작) 홀수자리가 숫자가 아닐시 Result 실패 상황(NonNumericAtExpectedPositionException) 을 반환한다`() {
        val input: List<String> = "1 + 2 / f + 1".split(" ")

        assertThat(input.validateNumberInExpression().isFailure).isTrue()
        assertThat(input.validateNumberInExpression().exceptionOrNull() is NonNumericAtExpectedPositionException).isTrue()
    }

    @Test
    fun `계산식 자릿수에서(1부터시작) 홀수자리가 모두 숫자일시 Result 성공 상황(입력된 값) 을 반환한다`() {
        val input: List<String> = "1 + 2 / 4 + 1".split(" ")

        assertThat(input.validateNumberInExpression().isSuccess).isTrue()
        assertThat(input.validateNumberInExpression().getOrNull() == "1 + 2 / 4 + 1".split(" ")).isTrue()
    }

    @Test
    fun `계산식 자릿수에서(1부터시작) 짝수자리가 사칙연산 기호가 아닐시 Result 실패 상황(InvalidOperatorException) 을 반환한다`() {
        val input: List<String> = "1 + 2 & 3 + 1".split(" ")

        assertThat(input.validateOperatorInExpression().isFailure).isTrue()
        assertThat(input.validateOperatorInExpression().exceptionOrNull() is InvalidOperatorException).isTrue()
    }

    @Test
    fun `계산식 자릿수에서(1부터시작) 짝수자리가 모두 사칙연산 기호일시 Result 성공 상황(입력된 값) 을 반환한다`() {
        val input: List<String> = "1 + 2 / 4 + 1".split(" ")

        assertThat(input.validateOperatorInExpression().isSuccess).isTrue()
        assertThat(input.validateOperatorInExpression().getOrNull() == "1 + 2 / 4 + 1".split(" ")).isTrue()
    }
}
