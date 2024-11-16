package step2.inputValidator

import step2.inputValidator.Validators.validEmptyString
import step2.inputValidator.Validators.validNull
import step2.inputValidator.Validators.validNumberInExpression
import step2.inputValidator.Validators.validOperatorInExpression
import step2.inputValidator.Validators.validStartsAndEndsWithNumber

object FourBasicOperationsValidatorFacade {
    fun validate(input: List<String>?): Result<List<String>> =
        input.validNull()
            .chain { it.validEmptyString() }
            .chain { it.validStartsAndEndsWithNumber() }
            .chain { it.validNumberInExpression() }
            .chain { it.validOperatorInExpression() }

    private fun <T, R> Result<T>.chain(next: (value: T) -> Result<R>): Result<R> {
        return fold(
            onSuccess = { next(it) },
            onFailure = { Result.failure(it) },
        )
    }
}
