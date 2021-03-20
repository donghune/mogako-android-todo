package com.namu.todo.util.android

import androidx.lifecycle.*

abstract class BaseViewModel<VC : ViewCommand, VS : ViewState>(
    initialState: VS
) : ViewModel() {

    private val _event = MutableLiveData<Event<VC>>()
    val event: LiveData<Event<VC>>
        get() = _event

    private val _state = MutableLiveData<VS>(initialState)
    val state: LiveData<VS>
        get() = _state

    protected fun callEvent(viewCommand: VC) {
        _event.value = Event(viewCommand)
    }

    protected fun postEvent(viewCommand: VC) {
        _event.postValue(Event(viewCommand))
    }

    protected fun updateState(block: (state: VS) -> VS) {
        _state.value = block(requireNotNull(state.value))
    }

    protected suspend fun updateStateOnSuspend(block: suspend (state: VS) -> VS) {
        _state.value = block(requireNotNull(state.value))
    }

    protected fun <T> mapState(block: VS.() -> T): LiveData<T> =
        state.map(block).distinctUntilChanged()

    protected inline fun <R> withState(block: VS.() -> R) = block(requireNotNull(state.value))
}
