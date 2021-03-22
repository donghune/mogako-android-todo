package com.namu.todo

import com.namu.todo.entity.TodoEntity
import com.namu.todo.entity.toTodoEntity
import com.namu.todo.entity.toTodoVo

class TodoRepository(
    private val todoDataSource: TodoDataSource
) {

    fun getAll() : List<TodoEntity> {
        return todoDataSource.getAll().map {
            it.toTodoEntity()
        }
    }

    fun getById(id : Int): TodoEntity? {
        return todoDataSource.getById(id)?.toTodoEntity()
    }

    fun update(todoEntity: TodoEntity) {
        todoDataSource.update(todoEntity.toTodoVo())
    }

    fun insert(todoEntity: TodoEntity) {
        todoDataSource.insert(todoEntity.toTodoVo())
    }

    fun delete(todoEntity: TodoEntity) {
        todoDataSource.delete(todoEntity.toTodoVo())
    }

}