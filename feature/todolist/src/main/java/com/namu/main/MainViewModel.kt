package com.namu.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.namu.common.entity.Todo
import com.namu.common.entity.toTodo
import com.namu.common.entity.toTodoEntity
import com.namu.common.util.BaseViewModel
import com.namu.common.view.NoneViewState
import com.namu.common.view.ViewState
import com.namu.todo.TodoRepository

class MainViewModel(
    private val todoRepository: TodoRepository
) : BaseViewModel<ViewState>(NoneViewState) {

    private val _todoList = MutableLiveData<List<Todo>>()
    val todoList: LiveData<List<Todo>> = _todoList

    fun updateTodoList() {
        _todoList.postValue(todoRepository.getAll().filterNot { it.isComplete }.map { it.toTodo() })
    }

    fun completeTodo(todo: Todo) {
        todoRepository.update(todo.toTodoEntity())
    }

}