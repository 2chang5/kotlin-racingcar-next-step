package step3.view.validator

@Deprecated("오버엔지니어링 이라 판단 미사용, 기록용으로만 남김")
@Suppress("UNCHECKED_CAST")
fun <I, R> castToLastValidatorReturnType(
    value: Any?,
    lastValidator: BaseValidator<I, R>,
): R? {
    return value as? R
}
