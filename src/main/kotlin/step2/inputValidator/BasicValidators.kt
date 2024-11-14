package step2.inputValidator

import step2.inputValidator.InputValidateException.InputIsEmptyException
import step2.inputValidator.InputValidateException.InputIsNullException

object BasicValidators {
    fun List<String>?.validNull(): Result<List<String>> {
        return if (this != null) Result.success(this) else Result.failure(InputIsNullException())
    }

    fun List<String>.validEmptyString(): Result<List<String>> =
        if (this.joinToString().isEmpty()) Result.success(this) else Result.failure(InputIsEmptyException())
}
