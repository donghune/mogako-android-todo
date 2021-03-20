package com.namu.todo.util.android

data class Event<T>(private val content: T) {

    var hasBeenHandled = false
        private set // Allow external read but not write

    fun call(action: (T) -> Unit) {
        if (hasBeenHandled) {
            return
        }
        hasBeenHandled = true
        action(content)
    }

    fun peek() = content
}
