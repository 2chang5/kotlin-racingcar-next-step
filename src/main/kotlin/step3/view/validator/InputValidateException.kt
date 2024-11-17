package step3.view.validator

sealed class InputValidateException : Throwable() {
    class InputIsNullException : InputValidateException()

    class InputIsEmptyException : InputValidateException()

    class NonNumericException : InputValidateException()
}
