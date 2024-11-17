package step3.view.validator.concrete

import step3.view.validator.BaseValidator
import step3.view.validator.InputValidateException
import step3.view.validator.InputValidateException.NonNumericException

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
