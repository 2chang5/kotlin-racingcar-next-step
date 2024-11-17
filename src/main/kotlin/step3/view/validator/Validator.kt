package step3.view.validator

// 책임 연쇄 패턴(Base또한 분리)
interface Validator<I, R> {
    fun validate(input: I): Result<*>
}
