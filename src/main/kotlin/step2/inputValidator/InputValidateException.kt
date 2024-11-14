package step2.inputValidator

sealed class InputValidateException : Throwable() {
    class InputIsNullException : InputValidateException()

    class InputIsEmptyException : InputValidateException()

    class NonNumericStartOrEndException : InputValidateException()

    class NonNumericAtExpectedPositionException : InputValidateException()

    class InvalidOperatorException : InputValidateException()
}
