package com.namu.common.util

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.namu.common.view.ViewState

abstract class BaseViewModel<VS : ViewState>(
    defaultViewState: VS
) : ViewModel() {

    private val _viewState = MutableLiveData(defaultViewState)
    val viewState: LiveData<VS>
        get() = _viewState

    protected fun updateState(state: VS) {
        _viewState.value = state
    }

}