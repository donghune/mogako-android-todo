package com.namu.todo.domain.repository

import com.namu.todo.domain.entity.Todo
import com.namu.todo.util.Result
import kotlinx.coroutines.flow.Flow

interface TodoRepository {
    fun insertTodo(todo: Todo): Result<Unit>

    fun deleteTodo(todo: Todo): Result<Unit>

    fun getAllTodo(): Result<Flow<List<Todo>>>

    fun getTodo(id: Int): Result<Flow<Todo>>

    fun updateTodo(todo: Todo): Result<Unit>
}
