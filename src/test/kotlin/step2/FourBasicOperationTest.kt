package step2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

// 사칙연산 테스트
class FourBasicOperationTest {
    @Nested
    inner class PlusTest {
        @Test
        fun `2 + 2 는 4이다 양수 + 양수 테스트`() {
            val operationResult = 2 + 2
            val expected = 4

            assertThat(operationResult).isEqualTo(expected)
        }

        @Test
        fun `2 + -1 은 1이다 양수 + 음수 테스트 `() {
            val operationResult = 2 + -1
            val expected = 1

            assertThat(operationResult).isEqualTo(expected)
        }

        @Test
        fun `-1 + -1 은 -2이다 음수 +음수 테스트`() {
            val operationResult = -1 + -1
            val expected = -2

            assertThat(operationResult).isEqualTo(expected)
        }
    }

    @Nested
    inner class MinusTest {
        @Test
        fun `2 - 2 는 0이다 양수 - 양수 테스트`() {
            val operationResult = 2 - 2
            val expected = 0

            assertThat(operationResult).isEqualTo(expected)
        }

        @Test
        fun `2 - -1 은 3이다 양수 - 음수 테스트 `() {
            val operationResult = 2 - -1
            val expected = 3

            assertThat(operationResult).isEqualTo(expected)
        }

        @Test
        fun `-1 - -1 은 0이다 음수 - 음수 테스트`() {
            val operationResult = -1 - -1
            val expected = 0

            assertThat(operationResult).isEqualTo(expected)
        }
    }

    @Nested
    inner class TimesTest {
        @Test
        fun `2 * 2 는 4이다 양수 * 양수 테스트`() {
            val operationResult = 2 * 2
            val expected = 4

            assertThat(operationResult).isEqualTo(expected)
        }

        @Test
        fun `2 * -1 은 -2이다 양수 * 음수 테스트 `() {
            val operationResult = 2 * -1
            val expected = -2

            assertThat(operationResult).isEqualTo(expected)
        }

        @Test
        fun `-1 * -1 은 1이다 음수 * 음수 테스트`() {
            val operationResult = -1 * -1
            val expected = 1

            assertThat(operationResult).isEqualTo(expected)
        }
    }

    @Nested
    inner class DivTest {
        @Test
        @DisplayName("2 / 2 는 1이다 양수 / 양수 테스트")
        fun `divide test 1`() {
            val operationResult = 2 / 2
            val expected = 1

            assertThat(operationResult).isEqualTo(expected)
        }

        @Test
        @DisplayName("2 / -1 은 -2이다 양수 / 음수 테스트")
        fun `divide test 2`() {
            val operationResult = 2 / -1
            val expected = -2

            assertThat(operationResult).isEqualTo(expected)
        }

        @Test
        @DisplayName("-1 / -1 은 1이다 음수 /음수 테스트")
        fun `divide test 3`() {
            val operationResult = -1 / -1
            val expected = 1

            assertThat(operationResult).isEqualTo(expected)
        }

        @Test
        fun `0으로 숫자를 나눌수 없다`() {
            assertThrows(ArithmeticException::class.java) {
                3 / 0
            }
        }
    }
}
