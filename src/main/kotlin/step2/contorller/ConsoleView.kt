package step2.contorller

interface ConsoleView {
    fun getMathExpression(): List<String>?

    fun printConclusion(result: Result<Int>)
}
