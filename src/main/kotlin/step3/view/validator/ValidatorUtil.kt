package step3.view.validator

@Suppress("UNCHECKED_CAST")
fun <I, R> castToLastValidatorReturnType(
    value: Any?,
    lastValidator: BaseValidator<I, R>,
): R? {
    return value as? R
}
