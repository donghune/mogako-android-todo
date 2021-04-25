package com.namu.todo.domain.interacotr

import com.namu.todo.domain.entity.Todo
import com.namu.todo.domain.repository.TodoRepository
import com.namu.todo.util.Result
import com.namu.todo.util.usecase.ActionUseCase
import javax.inject.Inject

class GetTodos @Inject constructor(
    private val repo: TodoRepository
) : ActionUseCase<List<Todo>>() {

    override suspend fun buildUseCase(params: Unit): Result<List<Todo>> = repo.getAllTodo()
}
