package com.namu.todo.domain.interacotr

import com.namu.todo.domain.entity.Todo
import com.namu.todo.domain.repository.TodoRepository
import com.namu.todo.util.Result
import com.namu.todo.util.usecase.UseCase
import javax.inject.Inject

class AddTodo @Inject constructor(
    private val repo: TodoRepository
) : UseCase<Todo, Unit>() {
    override suspend fun buildUseCase(params: Todo): Result<Unit> = repo.insertTodo(params)
}
