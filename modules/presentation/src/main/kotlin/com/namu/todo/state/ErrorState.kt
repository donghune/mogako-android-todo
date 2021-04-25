package com.namu.todo.state

sealed class ErrorState(
    override val message: String? = null,
    override val cause: Throwable? = null
) : Throwable(message, cause) {

    object Network : ErrorState()

    data class Server(
        override val cause: Throwable?
    ) : ErrorState(cause?.message, cause)

    data class Unknown(
        override val cause: Throwable?
    ) : ErrorState(cause?.message, cause)

    companion object {
        operator fun invoke(throwable: Throwable): ErrorState =
            ErrorState.Unknown(throwable)
    }
}
