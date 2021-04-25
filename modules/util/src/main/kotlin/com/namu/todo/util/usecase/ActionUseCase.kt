package com.namu.todo.util.usecase

import com.namu.todo.util.Result

abstract class ActionUseCase<T> : UseCase<Unit, T>() {

    suspend operator fun invoke(): Result<T> = invoke(Unit)
}
