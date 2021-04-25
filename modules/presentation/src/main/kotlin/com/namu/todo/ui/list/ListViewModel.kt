package com.namu.todo.ui.list

import com.namu.todo.util.android.BaseViewModel
import com.namu.todo.util.android.NoViewCommand
import com.namu.todo.util.android.NoViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor() : BaseViewModel<NoViewCommand, NoViewState>(NoViewState)
