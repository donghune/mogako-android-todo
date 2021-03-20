package com.namu.todo.util.usecase

import com.namu.todo.util.Result

abstract class UseCase<in Params, T> {

    suspend operator fun invoke(params: Params): Result<T> = buildUseCase(params)

    abstract suspend fun buildUseCase(params: Params): Result<T>
}
