package com.namu.common.entity

import com.namu.todo.entity.TodoEntity
import org.joda.time.LocalDateTime

fun Todo.toTodoEntity(): TodoEntity {
    return TodoEntity(
        id, content, date.toDate(), isUseReminder, isComplete
    )
}

fun TodoEntity.toTodo() : Todo {
    return Todo(
        id, title, LocalDateTime.fromDateFields(date), isUseReminder, isComplete
    )
}