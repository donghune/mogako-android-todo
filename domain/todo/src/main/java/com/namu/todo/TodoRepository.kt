package com.namu.todo

import com.namu.localdb.TodoDao
import com.namu.todo.entity.TodoEntity
import com.namu.todo.entity.toTodoEntity
import com.namu.todo.entity.toTodoVo

class TodoRepository(
    private val todoDao: TodoDao
) {

    fun getAll() : List<TodoEntity> {
        return todoDao.getAll().map {
            it.toTodoEntity()
        }
    }

    fun getById(id : Int): TodoEntity? {
        return todoDao.findById(id)?.toTodoEntity()
    }

    fun update(todoEntity: TodoEntity) {
        todoDao.update(todoEntity.toTodoVo())
    }

    fun insert(todoEntity: TodoEntity) {
        todoDao.insert(todoEntity.toTodoVo())
    }

    fun delete(todoEntity: TodoEntity) {
        todoDao.delete(todoEntity.toTodoVo())
    }

}