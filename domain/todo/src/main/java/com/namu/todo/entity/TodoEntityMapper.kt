package com.namu.todo.entity

import com.namu.localdb.TodoVo

fun TodoEntity.toTodoVo(): TodoVo {
    return TodoVo(
        id, title, date, isUseReminder, isComplete
    )
}

fun TodoVo.toTodoEntity(): TodoEntity {
    return TodoEntity(
        id, title, date, isUseReminder, isComplete
    )
}