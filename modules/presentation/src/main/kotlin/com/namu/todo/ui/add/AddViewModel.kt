package com.namu.todo.ui.add

import com.namu.todo.domain.interacotr.AddTodo
import com.namu.todo.util.android.BaseViewModel
import com.namu.todo.util.android.ViewCommand
import com.namu.todo.util.android.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(
    private val addTodo: AddTodo
) : BaseViewModel<AddViewModel.Command, AddViewModel.State>(State()) {

    sealed class Command() : ViewCommand

    data class State(
        val loading: Boolean = false
    ) : ViewState
}
