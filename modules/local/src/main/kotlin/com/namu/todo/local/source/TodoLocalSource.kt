package com.namu.todo.local.source

import com.namu.todo.domain.entity.Todo
import com.namu.todo.local.room.TodoDao
import com.namu.todo.source.TodoLocalDataSource
import com.namu.todo.util.Result
import com.namu.todo.util.buildResult
import com.namu.todo.util.buildResultCatching
import javax.inject.Inject

class TodoLocalSource @Inject constructor(
    private val dao: TodoDao
) : TodoLocalDataSource {
    override suspend fun insertTodo(todo: Todo): Result<Unit> = buildResult {
        dao.insertTodo(todo)
    }

    override suspend fun deleteTodo(todo: Todo): Result<Unit> = buildResult {
        dao.deleteTodo(todo)
    }

    override suspend fun updateTodo(todo: Todo): Result<Unit> = buildResult {
        dao.updateTodo(todo)
    }

    override suspend fun getAllTodo(): Result<List<Todo>> = buildResultCatching {
        dao.selectAllTodo()
    }

    override suspend fun getTodo(id: Int): Result<Todo> = buildResultCatching {
        dao.selectTodo(id)
    }
}
