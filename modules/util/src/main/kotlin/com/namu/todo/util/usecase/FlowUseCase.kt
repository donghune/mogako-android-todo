package com.namu.todo.util.usecase

import kotlinx.coroutines.flow.Flow

abstract class FlowUseCase<in Params, T> {

    suspend operator fun invoke(params: Params): Flow<T> = buildUseCase(params)

    abstract suspend fun buildUseCase(params: Params): Flow<T>
}
