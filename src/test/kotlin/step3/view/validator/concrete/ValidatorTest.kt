package step3.view.validator.concrete

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ValidatorTest {
    @Test
    fun `emptyString,Null,Number 검증기를 적용했을때 문자열을 입력한경우 실패상황을 반환한다`() {
        val result =
            NullValidator()
                .setNext(EmptyStringValidator())
                .setNext(NumberValidator()).validate("ㅏ")

        assertThat(result.isFailure).isTrue()
    }

    @Test
    fun `emptyString,Null,Number 검증기를 적용했을때 숫자를 입력한경우 성공상황을 반환한다`() {
        val result =
            NullValidator()
                .setNext(EmptyStringValidator())
                .setNext(NumberValidator()).validate("3")

        assertThat(result.isSuccess).isTrue()
    }
}
