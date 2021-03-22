package com.namu.main

import com.namu.todo.TodoRepository
import com.namu.common.entity.Todo
import com.namu.common.entity.toTodo
import com.namu.common.entity.toTodoEntity

class MainPresenter(
    private val view: MainContract.View,
    private val todoRepository: TodoRepository
) : MainContract.Presenter {

    override fun updateTodoList() {
        view.updateTodoList(todoRepository.getAll().map { it.toTodo() })
    }

    override fun completeTodo(todo: Todo) {
        todoRepository.update(todo.toTodoEntity())
    }

    override fun addTodo(todo: Todo) {
        todoRepository.insert(todo.toTodoEntity())
    }

}