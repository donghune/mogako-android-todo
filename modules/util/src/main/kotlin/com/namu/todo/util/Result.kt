package com.namu.todo.util

sealed class Result<out T> {

    data class Success<T> internal constructor(
        val value: T
    ) : Result<T>()

    data class Failure internal constructor(
        val throwable: Throwable
    ) : Result<Nothing>()

    val isSuccess: Boolean
        get() = this is Success

    val isFailure: Boolean
        get() = this is Failure

    fun getOrNull(): T? =
        when (this) {
            is Success -> value
            is Failure -> null
        }

    fun getOrThrow(): T =
        when (this) {
            is Success -> value
            is Failure -> throw throwable
        }

    fun getOrDefault(default: @UnsafeVariance T): T =
        when (this) {
            is Success -> value
            is Failure -> default
        }

    fun exceptionOrNull(): Throwable? =
        when (this) {
            is Success -> null
            is Failure -> throwable
        }

    inline fun onSuccess(action: (value: T) -> Unit): Result<T> {
        if (this is Success) action(value)
        return this
    }

    inline fun onSuccessCatching(action: (value: T) -> Unit): Result<T> =
        try {
            if (this is Success) action(value)
            this
        } catch (e: Throwable) {
            failure(e)
        }

    inline fun onFailure(action: (throwable: Throwable) -> Unit): Result<T> {
        if (this is Failure) action(throwable)
        return this
    }

    inline fun onFailureCatching(action: (throwable: Throwable) -> Unit): Result<T> =
        try {
            if (this is Failure) action(throwable)
            this
        } catch (e: Throwable) {
            failure(e)
        }

    inline fun toFailure(
        throwable: Throwable,
        condition: (value: T) -> Boolean = { true }
    ): Result<T> =
        if (this is Success && condition(value)) failure(throwable)
        else this

    inline fun <R> map(transform: (value: T) -> R): Result<R> =
        when (this) {
            is Success -> success(transform(value))
            is Failure -> this
        }

    inline fun <R> mapCatching(transform: (value: T) -> R): Result<R> =
        when (this) {
            is Success -> buildResultCatching { transform(value) }
            is Failure -> this
        }

    inline fun <R> flatMap(transform: (value: T) -> Result<R>): Result<R> =
        when (this) {
            is Success -> transform(value)
            is Failure -> this
        }

    inline fun <R> flatMapCatching(transform: (value: T) -> Result<R>): Result<R> =
        try {
            when (this) {
                is Success -> transform(value)
                is Failure -> this
            }
        } catch (e: Throwable) {
            failure(e)
        }

    inline fun recover(
        transform: (throwable: Throwable) -> Result<@UnsafeVariance T>
    ): Result<T> = when (this) {
        is Success -> this
        is Failure -> transform(throwable)
    }

    inline fun recoverCatching(
        transform: (throwable: Throwable) -> Result<@UnsafeVariance T>
    ): Result<T> = try {
        when (this) {
            is Success -> this
            is Failure -> transform(throwable)
        }
    } catch (e: Throwable) {
        failure(e)
    }

    inline fun <R> fold(
        onSuccess: (value: T) -> R,
        onFailure: (throwable: Throwable) -> R
    ): R = when (this) {
        is Success -> onSuccess(value)
        is Failure -> onFailure(throwable)
    }

    companion object {
        fun <T> success(value: T): Result<T> = Success(value)

        fun failure(throwable: Throwable): Result<Nothing> = Failure(throwable)
    }
}

inline fun <T> buildResult(block: () -> T): Result<T> = Result.success(block())

inline fun <T> buildResultCatching(block: () -> T): Result<T> =
    try {
        Result.success(block())
    } catch (e: Throwable) {
        Result.failure(e)
    }
