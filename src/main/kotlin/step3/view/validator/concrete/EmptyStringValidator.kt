package step3.view.validator.concrete

import step3.view.validator.BaseValidator
import step3.view.validator.InputValidateException
import step3.view.validator.InputValidateException.InputIsEmptyException

@Deprecated("오버엔지니어링 이라 판단 미사용, 기록용으로만 남김")
class EmptyStringValidator : BaseValidator<String, String>() {
    override fun validate(input: String): Result<*> {
        return if (input.isNotEmpty()) {
            passToNextValidator(input) ?: Result.success(input)
        } else {
            Result.failure<InputValidateException>(InputIsEmptyException())
        }
    }
}
