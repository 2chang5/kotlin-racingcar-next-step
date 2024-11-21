package step3.view.validator.concrete

import step3.view.validator.BaseValidator
import step3.view.validator.InputValidateException
import step3.view.validator.InputValidateException.NonNumericException

@Deprecated("오버엔지니어링 이라 판단 미사용, 기록용으로만 남김")
class NumberValidator : BaseValidator<String, Int>() {
    override fun validate(input: String): Result<*> {
        return if (input.toIntOrNull() != null) {
            val castedInput = input.toInt()
            passToNextValidator(castedInput) ?: Result.success(castedInput)
        } else {
            Result.failure<InputValidateException>(NonNumericException())
        }
    }
}
