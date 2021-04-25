package com.namu.todo.util.arch

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.*

interface ViewLifecycle {

    var lifecycleOwner: LifecycleOwner?

    @ExperimentalCoroutinesApi
    fun <T> Flow<T>.suspendUntil(state: Lifecycle.State = Lifecycle.State.RESUMED): Flow<T> =
        flatMapLatest { value ->
            lifecycleOwner
                ?.let { whenStateAtLeast(it, state) }
                ?: flow { emit(value) }
        }

    @ExperimentalCoroutinesApi
    fun <T> Flow<T>.onEachWhenResumed(
        action: suspend (T) -> Unit
    ): Flow<T> = suspendUntil().onEach(action)
}

@ExperimentalCoroutinesApi
fun <T> Flow<T>.whenStateAtLeast(
    lifecycleOwner: LifecycleOwner,
    targetState: Lifecycle.State
): Flow<T> {
    val currentState = lifecycleOwner.lifecycle.currentState
    if (currentState >= targetState) return this

    return flatMapLatest { value ->
        callbackFlow<T> {

            val observer = object : DefaultLifecycleObserver {

                override fun onCreate(owner: LifecycleOwner) = offer(Lifecycle.State.CREATED)
                override fun onStart(owner: LifecycleOwner) = offer(Lifecycle.State.STARTED)
                override fun onResume(owner: LifecycleOwner) = offer(Lifecycle.State.RESUMED)

                private fun offer(state: Lifecycle.State) {
                    if (state >= targetState) {
                        offer(value)
                        close()
                    }
                }
            }
            lifecycleOwner.lifecycle.addObserver(observer)
            awaitClose { lifecycleOwner.lifecycle.removeObserver(observer) }
        }
    }
}
