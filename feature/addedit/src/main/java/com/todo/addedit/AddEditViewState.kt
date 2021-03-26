package com.todo.addedit

import com.namu.common.entity.Todo
import com.namu.common.view.ViewState

sealed class AddEditViewState : ViewState {
    class SaveError(val message: String) : AddEditViewState()
    class SaveSuccess(val todo: Todo) : AddEditViewState()
}
