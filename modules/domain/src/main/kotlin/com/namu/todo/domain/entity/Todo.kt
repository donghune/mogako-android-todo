package com.namu.todo.domain.entity

data class Todo(
    val title: String,
    val description: String,
    val date: String,
    val isDone: Boolean
)
