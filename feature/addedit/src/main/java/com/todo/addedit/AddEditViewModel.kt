package com.todo.addedit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.namu.common.entity.Todo
import com.namu.common.entity.toTodoEntity
import com.namu.common.util.BaseViewModel
import com.namu.todo.TodoRepository
import com.namu.todo.entity.TodoEntity
import java.util.*

class AddEditViewModel(
    private val todoRepository: TodoRepository
) : BaseViewModel() {

    private val _id = MutableLiveData<Int>()

    private val _content = MutableLiveData<String>()
    val content: LiveData<String> = _content

    private val _date = MutableLiveData<Date>()
    val date: LiveData<Date> = _date

    private val _isUseReminder = MutableLiveData<Boolean>()
    val isUseReminder: LiveData<Boolean> = _isUseReminder

    fun setContent(value : String) {
        _content.value = value
    }
    fun setDate(value : Date) {
        _date.value = value
    }
    fun setIsUseReminder(value : Boolean) {
        _isUseReminder.value = value
    }

    fun setBeforeTodo(beforeTodo: Todo) {
        _id.value = beforeTodo.id
        _content.value = beforeTodo.content
        _date.value = beforeTodo.date
        _isUseReminder.value = beforeTodo.isUseReminder
    }

    fun clickAddEditButton(isNew: Boolean) {
        val todoEntity: TodoEntity = Todo(
            id = _id.value ?: 0,
            content = _content.value ?: "",
            date = _date.value ?: Date(),
            isUseReminder = _isUseReminder.value ?: false,
            isComplete = false
        ).toTodoEntity()

        if (isNew) {
            todoRepository.insert(todoEntity)
        } else {
            todoRepository.update(todoEntity)
        }
    }

}