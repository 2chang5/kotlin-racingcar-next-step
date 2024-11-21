package step3.view.validator

@Deprecated("오버엔지니어링 이라 판단 미사용, 기록용으로만 남김")
abstract class BaseValidator<I, R> : Validator<I, R> {
    private var nextValidator: Validator<R, *>? = null

    fun <NR> setNext(validator: Validator<R, NR>): BaseValidator<I, R> {
        this.nextValidator = validator
        return this
    }

    protected fun passToNextValidator(currentResult: R): Result<*>? {
        return nextValidator?.validate(currentResult)
    }
}
