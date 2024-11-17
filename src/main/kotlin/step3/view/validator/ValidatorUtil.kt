package step3.view.validator

fun <I, R> castToLastValidatorReturnType(
    value: Any?,
    lastValidator: BaseValidator<I, R>,
): R? {
    return value as? R
}
