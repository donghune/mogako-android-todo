package com.namu.todo.repository

import com.namu.todo.domain.entity.Todo
import com.namu.todo.domain.repository.TodoRepository
import com.namu.todo.source.TodoLocalDataSource
import com.namu.todo.util.Result
import javax.inject.Inject

class TodoRepositoryImpl @Inject constructor(
    private val local: TodoLocalDataSource
) : TodoRepository {
    override suspend fun insertTodo(todo: Todo): Result<Unit> = local.insertTodo(todo)

    override suspend fun deleteTodo(todo: Todo): Result<Unit> = local.deleteTodo(todo)

    override suspend fun getAllTodo(): Result<List<Todo>> = local.getAllTodo()

    override suspend fun getTodo(id: Int): Result<Todo> = local.getTodo(id)

    override suspend fun updateTodo(todo: Todo): Result<Unit> = local.updateTodo(todo)
}
