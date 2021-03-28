package com.namu.todo.source

import com.namu.todo.domain.entity.Todo
import com.namu.todo.util.Result

interface TodoLocalDataSource {
    suspend fun insertTodo(todo: Todo): Result<Unit>

    suspend fun deleteTodo(todo: Todo): Result<Unit>

    suspend fun updateTodo(todo: Todo): Result<Unit>

    suspend fun getAllTodo(): Result<List<Todo>>

    suspend fun getTodo(id: Int): Result<Todo>
}
