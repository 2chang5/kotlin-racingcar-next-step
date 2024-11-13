package step2

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

// 사칙연산 테스트
class FourBasicOperationTest {
    @Nested
    inner class PlusTest {
        @Test
        fun `2 + 2 는 4이다 양수 + 양수 테스트`() {
        }

        @Test
        fun `2 + -1 은 1이다 양수 + 음수 테스트 `() {
        }

        @Test
        fun `-1 + -1 은 -2이다 음수 +음수 테스트`() {
        }
    }

    @Nested
    inner class MinusTest {
        @Test
        fun `2 - 2 는 0이다 양수 - 양수 테스트`() {
        }

        @Test
        fun `2 - -1 은 3이다 양수 - 음수 테스트 `() {
        }

        @Test
        fun `-1 - -1 은 0이다 음수 - 음수 테스트`() {
        }
    }

    @Nested
    inner class TimesTest {
        @Test
        fun `2 * 2 는 4이다 양수 * 양수 테스트`() {
        }

        @Test
        fun `2 * -1 은 -2이다 양수 * 음수 테스트 `() {
        }

        @Test
        fun `-1 * -1 은 1이다 음수 * 음수 테스트`() {
        }
    }

    @Nested
    inner class DivTest {
        @Test
        @DisplayName("2 / 2 는 1이다 양수 / 양수 테스트")
        fun `divide test 1`() {
        }

        @Test
        @DisplayName("2 / -1 은 -2이다 양수 / 음수 테스트")
        fun `divide test 2`() {
        }

        @Test
        @DisplayName("-1 / -1 은 1이다 음수 /음수 테스트")
        fun `divide test 3`() {
        }

        @Test
        fun `0으로 숫자를 나눌수 없다`() {
        }
    }
}
