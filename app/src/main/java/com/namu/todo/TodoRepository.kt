package com.namu.todo

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData

class TodoRepository(private val todoDao: TodoDao) {
    val allTodo: LiveData<List<Todo>> = todoDao.getAll()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(todo: Todo) {
        todoDao.insert(todo)
    }
}