package com.namu.todo.util.coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

fun CoroutineScope.launch(
    context: CoroutineContext = EmptyCoroutineContext,
    start: CoroutineStart = CoroutineStart.DEFAULT,
    onError: (throwable: Throwable) -> Unit = { },
    block: suspend CoroutineScope.() -> Unit
): Job {
    val handler = CoroutineExceptionHandler { _, throwable -> onError(throwable) }
    return launch(
        context = context + handler,
        start = start,
        block = block
    )
}

suspend fun <T> CoroutineScope.withDelayed(timeMillis: Long, block: suspend () -> T): T {
    val delay = coroutineScope { launch { delay(timeMillis) } }
    val ret = block()
    delay.join()
    return ret
}

suspend fun <T> CoroutineScope.postDelayed(timeMillis: Long, block: suspend () -> Unit) {
    delay(timeMillis)
    block()
}
