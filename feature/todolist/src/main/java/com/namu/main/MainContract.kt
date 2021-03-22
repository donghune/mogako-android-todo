package com.namu.main

import com.namu.common.entity.Todo


interface MainContract {

    interface View {

        fun updateTodoList(todoList: List<Todo>)

    }

    interface Presenter {

        fun updateTodoList()

        fun completeTodo(todo: Todo)

        fun addTodo(todo: Todo)

    }

}