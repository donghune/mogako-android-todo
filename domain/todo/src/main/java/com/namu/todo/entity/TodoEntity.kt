package com.namu.todo.entity

import java.util.*

data class TodoEntity(
    val id: Int,
    val title: String,
    val date: Date,
    val isUseReminder: Boolean,
    val isComplete: Boolean
)