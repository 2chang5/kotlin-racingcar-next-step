package step2.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BinaryCalculatorTest {
    @Test
    fun `임의의 계산식 계산 테스트(정답)`() {
        val result = BinaryCalculator("1 + 2 + 3 / 2 + 5 - 3 + 1 * 3 / 7".split(" ")).calculate()
        assertThat(result).isEqualTo(2.5714285714285716)
    }
}
