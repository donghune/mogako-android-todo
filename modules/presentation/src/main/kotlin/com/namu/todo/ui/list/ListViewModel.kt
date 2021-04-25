package com.namu.todo.ui.list

import com.namu.todo.base.BaseViewModel
import com.namu.todo.domain.interacotr.GetAllTodo
import com.namu.todo.util.android.NoViewCommand
import com.namu.todo.util.android.NoViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    getAllTodo: GetAllTodo
) : BaseViewModel<NoViewCommand, NoViewState>(NoViewState)
