package com.todo.addedit

import com.namu.todo.TodoRepository
import com.namu.common.entity.Todo
import com.namu.common.entity.toTodoEntity

class AddEditPresenter(
    val view: com.todo.addedit.AddEditContract.View,
    private val repository: TodoRepository
) : com.todo.addedit.AddEditContract.Presenter {

    override fun updateTodo(todo: Todo) {
        repository.update(todo.toTodoEntity())
    }

    override fun createTodo(todo: Todo) {
        repository.insert(todo.toTodoEntity())
    }

}