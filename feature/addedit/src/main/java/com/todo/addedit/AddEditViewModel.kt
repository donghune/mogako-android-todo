package com.todo.addedit

import androidx.lifecycle.MutableLiveData
import com.namu.common.util.BaseViewModel
import com.namu.todo.TodoRepository
import com.namu.todo.entity.TodoEntity
import java.util.*

class AddEditViewModel(
    private val todoRepository: TodoRepository
) : BaseViewModel() {

    private val _content = MutableLiveData<String>()
    private val _date = MutableLiveData<Date>()
    private val _isUseReminder = MutableLiveData<Boolean>()

    fun updateContent(content: String) {
        _content.value = content
    }

    fun updateDate(date: Date) {
        _date.postValue(date)
    }

    fun updateIsUseReminder(isReminder: Boolean) {
        _isUseReminder.postValue(isReminder)
    }

    fun addTodo() {
        todoRepository.insert(
            TodoEntity(
                id = 0,
                title = _content.value ?: "",
                date = _date.value ?: Date(),
                isUseReminder = _isUseReminder.value ?: false,
                isComplete = false
            )
        )
    }

}