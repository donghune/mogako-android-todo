package com.namu.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.namu.common.entity.Todo
import com.namu.common.entity.toTodo
import com.namu.common.entity.toTodoEntity
import com.namu.todo.TodoRepository

class MainViewModel(
    private val todoRepository: TodoRepository
) : ViewModel() {

    private val _todoList = MutableLiveData<List<Todo>>()
    val todoList: LiveData<List<Todo>> = _todoList

    fun updateTodoList() {
        _todoList.postValue(todoRepository.getAll().map { it.toTodo() })
    }

    fun completeTodo(todo: Todo) {
        todoRepository.update(todo.toTodoEntity())
    }

    fun addTodo(todo: Todo) {
        todoRepository.insert(todo.toTodoEntity())
    }

}