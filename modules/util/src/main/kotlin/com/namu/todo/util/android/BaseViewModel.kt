package com.namu.todo.util.android

import androidx.lifecycle.*
import com.namu.todo.util.arch.ViewLifecycle
import com.namu.todo.util.logger.Logger

abstract class BaseViewModel<VC : ViewCommand, VS : ViewState>(
    initialState: VS
) : ViewModel(), ViewLifecycle {

    @Suppress("PropertyName")
    protected inline val TAG: String
        get() = this::class.java.simpleName

    private val _event: MutableLiveData<Event<VC>> = MutableLiveData<Event<VC>>()
    val event: LiveData<Event<VC>>
        get() = _event

    private val _state: MutableLiveData<VS> = MutableLiveData<VS>(initialState)
    val state: LiveData<VS>
        get() = _state

    override var lifecycleOwner: LifecycleOwner? = null

    fun requireState(): VS = state.value!!

    protected fun callEvent(viewCommand: VC) {
        Logger.d("callEvent, $viewCommand")
        _event.value = Event(viewCommand)
    }

    protected fun postEvent(viewCommand: VC) {
        Logger.d("postEvent, $viewCommand")
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

    override fun onCleared() {
        lifecycleOwner = null
        super.onCleared()
    }
}
