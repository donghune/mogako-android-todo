package com.todo.addedit

import com.namu.common.view.ViewState

sealed class AddEditViewState : ViewState {
    class SaveError(val message : String) : AddEditViewState()
    object SaveSuccess : AddEditViewState()
}
