package com.namu.todo

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class TodoRepository(private val todoDao: TodoDao) {
    val allTodo: Flow<List<Todo>>
        get() = todoDao.getAll()

    suspend fun insert(todo: Todo) {
        todoDao.insert(todo)
    }
}