package com.namu.todo.domain.repository

import com.namu.todo.domain.entity.Todo
import com.namu.todo.util.Result

interface TodoRepository {
    suspend fun insertTodo(todo: Todo): Result<Unit>

    suspend fun deleteTodo(todo: Todo): Result<Unit>

    suspend fun getAllTodo(): Result<List<Todo>>

    suspend fun getTodo(id: Int): Result<Todo>

    suspend fun updateTodo(todo: Todo): Result<Unit>
}
