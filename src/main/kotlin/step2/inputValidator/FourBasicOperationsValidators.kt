package step2.inputValidator

import step2.inputValidator.InputValidateException.InvalidOperatorException
import step2.inputValidator.InputValidateException.NonNumericAtExpectedPositionException
import step2.inputValidator.InputValidateException.NonNumericStartOrEndException

object FourBasicOperationsValidators {
    private const val PLUS_NOTATION = "+"
    private const val MINUS_NOTATION = "-"
    private const val TIMES_NOTATION = "*"
    private const val DIVIDE_NOTATION = "/"
    private val FourBasicOperationsNotations = listOf(PLUS_NOTATION, MINUS_NOTATION, TIMES_NOTATION, DIVIDE_NOTATION)

    fun List<String>.validStartsAndEndsWithNumber(): Result<List<String>> =
        if (this.first().toIntOrNull() != null && this.last().toIntOrNull() != null) {
            Result.success(this)
        } else {
            Result.failure(NonNumericStartOrEndException())
        }

    fun List<String>.validateNumberInExpression(): Result<List<String>> {
        this.asSequence().filterIndexed { index, _ ->
            // 계산식 index가 1부터시작한다고 가정했을때 홀수만 수집
            (index + 1) % 2 != 0
        }.forEach { input ->
            input.toIntOrNull() ?: return Result.failure(NonNumericAtExpectedPositionException())
        }

        return Result.success(this)
    }

    fun List<String>.validateOperatorInExpression(): Result<List<String>> {
        this.asSequence().filterIndexed { index, _ ->
            // 계산식 index가 1부터 시작한다고 가정했을때 짝수만 수집
            (index + 1) % 2 == 0
        }.forEach { input ->
            if (!isValidOperator(input)) return Result.failure(InvalidOperatorException())
        }

        return Result.success(this)
    }

    private fun isValidOperator(operator: String): Boolean = operator in FourBasicOperationsNotations
}
