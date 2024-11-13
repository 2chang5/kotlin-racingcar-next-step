package step2.domain.fourBasicOperations

import step2.domain.Operation

class Divide(private val first: Int, private val second: Int) : Operation {
    override fun execute(): Int = first / second
}
