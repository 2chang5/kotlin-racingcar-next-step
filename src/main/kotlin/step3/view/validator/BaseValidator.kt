package step3.view.validator

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
