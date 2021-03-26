package com.todo.addedit

import androidx.lifecycle.MutableLiveData
import com.namu.common.entity.Todo
import com.namu.common.entity.toTodoEntity
import com.namu.common.util.BaseViewModel
import com.namu.common.view.NoneViewState
import com.namu.common.view.ViewState
import com.namu.todo.TodoRepository
import java.util.*

class AddEditViewModel(
    private val todoRepository: TodoRepository
) : BaseViewModel<ViewState>(NoneViewState) {

    private val _id = MutableLiveData<Int>()

    val content = MutableLiveData<String>()

    val date = MutableLiveData<Date>()

    val isUseReminder = MutableLiveData<Boolean>()

    private var isNewTodo: Boolean = true

    fun onTodoLoaded(beforeTodo: Todo) {
        _id.value = beforeTodo.id
        content.value = beforeTodo.content
        date.value = beforeTodo.date.toDate()
        isUseReminder.value = beforeTodo.isUseReminder
        isNewTodo = false
    }

    private fun createTodo(todo: Todo) {
        todoRepository.insert(todo.toTodoEntity())
        updateState(AddEditViewState.SaveSuccess(todo))
    }

    private fun updateTodo(todo: Todo) {
        todoRepository.update(todo.toTodoEntity())
        updateState(AddEditViewState.SaveSuccess(todo))
    }

    fun saveTodo() {
        val currentId = _id.value ?: 0
        val currentContent = content.value
        val currentDate = date.value ?: Date()
        val currentIsUseReminder = isUseReminder.value ?: false

        if (currentContent.isNullOrEmpty()) {
            updateState(AddEditViewState.SaveError("내용을 입력해주세요."))
            return
        }

        val todo = Todo(
            currentId,
            currentContent,
            currentDate,
            currentIsUseReminder,
            false
        )

        if (isNewTodo) {
            createTodo(todo)
        } else {
            updateTodo(todo)
        }
    }

}