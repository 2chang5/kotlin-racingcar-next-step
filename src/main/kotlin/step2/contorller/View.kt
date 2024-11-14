package step2.contorller

interface View {
    fun getMathExpression(): List<String>?

    fun printConclusion(result: Result<Double>)
}
