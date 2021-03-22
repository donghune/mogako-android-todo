package com.namu.common.entity

import com.namu.todo.entity.TodoEntity

fun Todo.toTodoEntity(): TodoEntity {
    return TodoEntity(
        id, content, date, isUseReminder, isComplete
    )
}

fun TodoEntity.toTodo() : Todo {
    return Todo(
        id, title, date, isUseReminder, isComplete
    )
}