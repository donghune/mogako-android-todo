package com.namu.todo

import com.namu.localdb.TodoVo

interface TodoDataSource {

    fun getAll(): List<TodoVo>

    fun getById(id: Int): TodoVo?

    fun insert(todo: TodoVo)

    fun delete(todo: TodoVo)

    fun update(todo: TodoVo)

}