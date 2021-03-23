package com.namu.common.entity

import java.util.*

data class Todo(
    val id: Int,
    val content: String,
    val date: Date,
    val isUseReminder: Boolean,
    var isComplete: Boolean
)