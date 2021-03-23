package com.todo.addedit

import com.namu.common.util.BaseViewModel
import com.namu.todo.TodoRepository

class AddEditViewModel(
    val todoRepository: TodoRepository
) : BaseViewModel()