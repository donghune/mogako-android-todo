package com.namu.todo

import androidx.annotation.WorkerThread

class TodoRepository(private val todoDao: TodoDao) {
    val allTodo: kotlinx.coroutines.flow.Flow<List<Todo>> = todoDao.getAll()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(todo: Todo) {
        todoDao.insert(todo)
    }
}