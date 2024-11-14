package step2.domain

private const val OVERLAND_NUMBER_ERROR_MESSAGE = "연산자가 요구하는 이상의 숫자 갯수가 입력되었습니다."

enum class Operation(val notation: String) {
    PLUS("+") {
        override fun execute(vararg args: Int): Int {
            require(args.size == 2) { OVERLAND_NUMBER_ERROR_MESSAGE }
            return args[0] + args[1]
        }
    },
    MINUS("-") {
        override fun execute(vararg args: Int): Int {
            require(args.size == 2) { OVERLAND_NUMBER_ERROR_MESSAGE }
            return args[0] - args[1]
        }
    },
    TIMES("*") {
        override fun execute(vararg args: Int): Int {
            require(args.size == 2) { OVERLAND_NUMBER_ERROR_MESSAGE }
            return args[0] * args[1]
        }
    },
    DIVIDE("/") {
        override fun execute(vararg args: Int): Int {
            require(args.size == 2) { OVERLAND_NUMBER_ERROR_MESSAGE }
            return args[0] / args[1]
        }
    }, ;

    abstract fun execute(vararg args: Int): Int

    companion object {
        private val notationToEnumMap: Map<String, Operation> by lazy { entries.associateBy { it.notation } }

        fun getOperationByNotation(notation: String): Operation? = notationToEnumMap[notation]
    }
}
