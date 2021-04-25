package com.namu.todo.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.namu.todo.state.ErrorState
import com.namu.todo.state.LoadState
import com.namu.todo.util.android.BaseViewModel
import com.namu.todo.util.android.Event
import com.namu.todo.util.android.ViewCommand
import com.namu.todo.util.android.ViewState
import com.namu.todo.util.coroutines.launch
import com.namu.todo.util.time.Throttle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

abstract class BaseViewModel<VC : ViewCommand, VS : ViewState>(
    private val initialState: VS,
    loadState: LoadState = LoadState.INITIALIZE
) : BaseViewModel<VC, VS>(initialState) {

    private val _error = MutableLiveData<Event<ErrorState>>()
    val error: LiveData<Event<ErrorState>>
        get() = _error

    private val _loadState = MutableLiveData(loadState)
    val loadState: LiveData<LoadState>
        get() = _loadState

    protected fun updateLoadState(loadState: LoadState) {
        _loadState.value = loadState
    }

    protected fun LiveData<VS>.clear() = updateState { initialState }

    protected val throttle by lazy { Throttle(throttleInterval) }
    protected open val throttleInterval: Long = 500L

    protected fun launch(
        context: CoroutineContext = EmptyCoroutineContext,
        start: CoroutineStart = CoroutineStart.DEFAULT,
        onError: (throwable: Throwable) -> Unit = ::onError,
        block: suspend CoroutineScope.() -> Unit
    ): Job = viewModelScope.launch(
        context,
        start,
        block = {
            if (_loadState.value != LoadState.INITIALIZE) {
                _loadState.value = LoadState.LOADING
            }
            block()
            _loadState.value = LoadState.NOT_LOADING
        },
        onError = { throwable ->
            _loadState.postValue(LoadState.ERROR)
            onError(throwable)
        }
    )

    protected fun call(
        context: CoroutineContext = EmptyCoroutineContext,
        start: CoroutineStart = CoroutineStart.DEFAULT,
        onError: (throwable: Throwable) -> Unit = ::onError,
        block: suspend CoroutineScope.() -> Unit
    ) = viewModelScope.launch(context, start, onError, block)

    protected fun <T> Flow<T>.launchIn(coroutineScope: CoroutineScope = viewModelScope): Job =
        coroutineScope.launch(onError = ::onError) {
            catch { onError(it) }.collect()
        }

    open fun onError(throwable: Throwable) {
        throwable.printStackTrace()
        _error.postValue(Event(ErrorState(throwable)))
    }

    protected fun <T> Flow<T>.asLiveData(
        context: CoroutineContext = EmptyCoroutineContext,
        timeoutInMs: Long = 5000L
    ): LiveData<T> = liveData(context, timeoutInMs) {
        catch { onError(it) }.collect { emit(it) }
    }
}
