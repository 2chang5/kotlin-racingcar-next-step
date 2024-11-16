package step2.inputValidator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import step2.consoleView.inputValidator.FourBasicOperationsValidatorFacade
import step2.consoleView.inputValidator.InputValidateException
import step2.consoleView.inputValidator.InputValidateException.InputIsEmptyException
import step2.consoleView.inputValidator.InputValidateException.InputIsNullException
import step2.consoleView.inputValidator.InputValidateException.InvalidOperatorException
import step2.consoleView.inputValidator.InputValidateException.NonNumericAtExpectedPositionException

class FourBasicOperationsValidatorFacadeTest {
    @Test
    fun `계산식이 null로 들어올시 Result 실패 상황(InputIsNullException) 을 반환한다`() {
        val input: List<String>? = null

        assertThat(FourBasicOperationsValidatorFacade.validate(input).isFailure).isTrue()
        assertThat(
            FourBasicOperationsValidatorFacade.validate(input).exceptionOrNull() is InputIsNullException,
        ).isTrue()
    }

    @Test
    fun `계산식이 null이 아닐시 Result 성공 상황(입력된 값) 을 반환한다`() {
        val input: List<String> = "1 + 1".split(" ")

        assertThat(FourBasicOperationsValidatorFacade.validate(input).isSuccess).isTrue()
        assertThat(FourBasicOperationsValidatorFacade.validate(input).getOrNull() == "1 + 1".split(" ")).isTrue()
    }

    @Test
    fun `계산식이 빈스트링으로 들어올시 Result 실패 상황(InputIsEmptyException) 을 반환한다`() {
        val input: List<String> = "     ".split(" ")

        assertThat(FourBasicOperationsValidatorFacade.validate(input).isFailure).isTrue()
        assertThat(
            FourBasicOperationsValidatorFacade.validate(input).exceptionOrNull() is InputIsEmptyException,
        ).isTrue()
    }

    @Test
    fun `계산식이 빈스트링이 아닐시 Result 성공 상황(입력된 값) 을 반환한다`() {
        val input: List<String> = "1 + 1".split(" ")

        assertThat(FourBasicOperationsValidatorFacade.validate(input).isSuccess).isTrue()
        assertThat(FourBasicOperationsValidatorFacade.validate(input).getOrNull() == "1 + 1".split(" ")).isTrue()
    }

    @Test
    fun `계산식이 숫자로 시작하지 않을 경우 Result 실패 상황(NonNumericStartOrEndException) 을 반환한다`() {
        val input: List<String> = "d + 1".split(" ")

        assertThat(FourBasicOperationsValidatorFacade.validate(input).isFailure).isTrue()
        assertThat(
            FourBasicOperationsValidatorFacade.validate(input)
                .exceptionOrNull() is InputValidateException.NonNumericStartOrEndException,
        ).isTrue()
    }

    @Test
    fun `계산식이 숫자로 끝나지 않을 경우 Result 실패 상황(NonNumericStartOrEndException) 을 반환한다`() {
        val input: List<String> = "1 + d".split(" ")

        assertThat(FourBasicOperationsValidatorFacade.validate(input).isFailure).isTrue()
        assertThat(
            FourBasicOperationsValidatorFacade.validate(input)
                .exceptionOrNull() is InputValidateException.NonNumericStartOrEndException,
        ).isTrue()
    }

    @Test
    fun `계산식 시작과 끝이 숫자로 끝날시 Result 성공 상황(입력된 값) 을 반환한다`() {
        val input: List<String> = "1 + 1".split(" ")

        assertThat(FourBasicOperationsValidatorFacade.validate(input).isSuccess).isTrue()
        assertThat(FourBasicOperationsValidatorFacade.validate(input).getOrNull() == "1 + 1".split(" ")).isTrue()
    }

    @Test
    fun `계산식 자릿수에서(1부터시작) 홀수자리가 숫자가 아닐시 Result 실패 상황(NonNumericAtExpectedPositionException) 을 반환한다`() {
        val input: List<String> = "1 + 2 / f + 1".split(" ")

        assertThat(FourBasicOperationsValidatorFacade.validate(input).isFailure).isTrue()
        assertThat(
            FourBasicOperationsValidatorFacade.validate(input)
                .exceptionOrNull() is NonNumericAtExpectedPositionException,
        ).isTrue()
    }

    @Test
    fun `계산식 자릿수에서(1부터시작) 홀수자리가 모두 숫자일시 Result 성공 상황(입력된 값) 을 반환한다`() {
        val input: List<String> = "1 + 2 / 4 + 1".split(" ")

        assertThat(FourBasicOperationsValidatorFacade.validate(input).isSuccess).isTrue()
        assertThat(
            FourBasicOperationsValidatorFacade.validate(input).getOrNull() == "1 + 2 / 4 + 1".split(" "),
        ).isTrue()
    }

    @Test
    fun `계산식 자릿수에서(1부터시작) 짝수자리가 사칙연산 기호가 아닐시 Result 실패 상황(InvalidOperatorException) 을 반환한다`() {
        val input: List<String> = "1 + 2 & 3 + 1".split(" ")

        assertThat(FourBasicOperationsValidatorFacade.validate(input).isFailure).isTrue()
        assertThat(
            FourBasicOperationsValidatorFacade.validate(input).exceptionOrNull() is InvalidOperatorException,
        ).isTrue()
    }

    @Test
    fun `계산식 자릿수에서(1부터시작) 짝수자리가 모두 사칙연산 기호일시 Result 성공 상황(입력된 값) 을 반환한다`() {
        val input: List<String> = "1 + 2 / 4 + 1".split(" ")

        assertThat(FourBasicOperationsValidatorFacade.validate(input).isSuccess).isTrue()
        assertThat(
            FourBasicOperationsValidatorFacade.validate(input).getOrNull() == "1 + 2 / 4 + 1".split(" "),
        ).isTrue()
    }
}
