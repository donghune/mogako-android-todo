package com.namu.todo.domain.interacotr

import com.namu.todo.domain.entity.Todo
import com.namu.todo.domain.repository.TodoRepository
import com.namu.todo.util.usecase.FlowUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllTodo @Inject constructor(
    private val repo: TodoRepository
) : FlowUseCase<Unit, List<Todo>>() {

    override suspend fun buildUseCase(params: Unit): Flow<List<Todo>> = flow {
        emit(repo.getAllTodo().getOrThrow())
    }
}
