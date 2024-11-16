package step2.inputValidator

import step2.inputValidator.Validators.validEmptyString
import step2.inputValidator.Validators.validNull
import step2.inputValidator.Validators.validStartsAndEndsWithNumber
import step2.inputValidator.Validators.validateNumberInExpression
import step2.inputValidator.Validators.validateOperatorInExpression

object FourBasicOperationsValidatorFacade {
    fun validate(input: List<String>?): Result<List<String>> =
        input.validNull()
            .chain { it.validEmptyString() }
            .chain { it.validStartsAndEndsWithNumber() }
            .chain { it.validateNumberInExpression() }
            .chain { it.validateOperatorInExpression() }

    private fun <T, R> Result<T>.chain(next: (value: T) -> Result<R>): Result<R> {
        return fold(
            onSuccess = { next(it) },
            onFailure = { Result.failure(it) },
        )
    }
}
