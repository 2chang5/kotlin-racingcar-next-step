package step3.view.validator.concrete

import step3.view.validator.BaseValidator
import step3.view.validator.InputValidateException
import step3.view.validator.InputValidateException.InputIsNullException

@Deprecated("오버엔지니어링 이라 판단 미사용, 기록용으로만 남김")
class NullValidator : BaseValidator<String?, String>() {
    override fun validate(input: String?): Result<*> {
        return if (input != null) {
            passToNextValidator(input) ?: Result.success(input)
        } else {
            Result.failure<InputValidateException>(InputIsNullException())
        }
    }
}
