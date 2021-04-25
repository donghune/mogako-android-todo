package com.namu.todo.util.logger

import android.util.Log

object Logger {
    private fun tag(): String {
        val trace = Thread.currentThread().stackTrace[4]
        val fileName = trace.fileName
        val classPath = trace.className
        val className = classPath.substring(classPath.lastIndexOf(".") + 1)
        val methodName = trace.methodName
        val lineNumber = trace.lineNumber
        return "$className.$methodName($fileName:$lineNumber)"
    }
    fun v(msg: String) {
        Log.v(tag(), msg)
    }

    fun d(msg: String) {
        Log.d(tag(), msg)
    }

    fun i(msg: String) {
        Log.i(tag(), msg)
    }

    fun w(msg: String) {
        Log.w(tag(), msg)
    }

    fun e(msg: String) {
        Log.e(tag(), msg)
    }
}
