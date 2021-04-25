package com.namu.todo.util.time

import java.util.concurrent.TimeUnit

class Throttle(
    interval: Long = 2000L,
    timeUnit: TimeUnit = TimeUnit.MILLISECONDS
) {
    private val interval: Long = timeUnit.toMillis(interval)
    private var lastCallTime: Long = Long.MIN_VALUE

    operator fun invoke(block: () -> Unit) {
        val now = System.currentTimeMillis()
        if (lastCallTime != Long.MIN_VALUE && (now - lastCallTime < interval)) {
            return
        }
        lastCallTime = now
        block()
    }
}
