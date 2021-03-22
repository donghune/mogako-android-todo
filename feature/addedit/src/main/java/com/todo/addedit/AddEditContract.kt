package com.todo.addedit

import com.namu.common.entity.Todo

interface AddEditContract {

    interface View

    interface Presenter {

        fun updateTodo(todo: Todo)

        fun createTodo(todo: Todo)

    }

}