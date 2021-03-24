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

    private val _todo = MutableLiveData<Todo>()
    val todo: LiveData<Todo>
        get() = _todo

    fun setBeforeTodo(beforeTodo: Todo?) {
        _todo.value = beforeTodo
    }

    fun clickAddEditButton(isNew: Boolean) {
        val todoEntity : TodoEntity = (_todo.value ?: Todo(
            id = 0,
            content = "",
            date = Date(),
            isUseReminder = false,
            isComplete = false
        )).toTodoEntity()

        if (isNew) {
            todoRepository.insert(todoEntity)
        } else {
            todoRepository.update(todoEntity)
        }
    }

}