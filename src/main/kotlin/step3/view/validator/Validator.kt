package step3.view.validator

// 책임 연쇄 패턴(Base또한 분리)
@Deprecated("오버엔지니어링 이라 판단 미사용, 기록용으로만 남김")
interface Validator<I, R> {
    fun validate(input: I): Result<*>
}
