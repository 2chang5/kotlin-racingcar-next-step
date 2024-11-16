package step2.consoleView.inputValidator

import step2.consoleView.inputValidator.InputValidateException.InputIsEmptyException
import step2.consoleView.inputValidator.InputValidateException.InputIsNullException
import step2.consoleView.inputValidator.InputValidateException.InvalidOperatorException
import step2.consoleView.inputValidator.InputValidateException.NonNumericAtExpectedPositionException
import step2.consoleView.inputValidator.InputValidateException.NonNumericStartOrEndException

object Validators {
    private const val PLUS_NOTATION = "+"
    private const val MINUS_NOTATION = "-"
    private const val TIMES_NOTATION = "*"
    private const val DIVIDE_NOTATION = "/"
    private val FourBasicOperationsNotations = listOf(PLUS_NOTATION, MINUS_NOTATION, TIMES_NOTATION, DIVIDE_NOTATION)

    fun List<String>?.validNull(): Result<List<String>> {
        return if (this != null) Result.success(this) else Result.failure(InputIsNullException())
    }

    fun List<String>.validEmptyString(): Result<List<String>> =
        if (this.joinToString(separator = "").isNotEmpty()) Result.success(this) else Result.failure(InputIsEmptyException())

    fun List<String>.validStartsAndEndsWithNumber(): Result<List<String>> =
        if (this.first().toIntOrNull() != null && this.last().toIntOrNull() != null) {
            Result.success(this)
        } else {
            Result.failure(NonNumericStartOrEndException())
        }

    fun List<String>.validNumberInExpression(): Result<List<String>> {
        this.asSequence().filterIndexed { index, _ ->
            // 계산식 index가 1부터시작한다고 가정했을때 홀수만 수집
            (index + 1) % 2 != 0
        }.forEach { input ->
            input.toIntOrNull() ?: return Result.failure(NonNumericAtExpectedPositionException())
        }

        return Result.success(this)
    }

    fun List<String>.validOperatorInExpression(): Result<List<String>> {
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
