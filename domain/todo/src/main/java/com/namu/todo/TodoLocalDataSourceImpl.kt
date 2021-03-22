package com.namu.todo

import com.namu.localdb.TodoDao
import com.namu.localdb.TodoVo

class TodoLocalDataSourceImpl(
    private val todoDao: TodoDao
) : TodoDataSource {

    override fun getAll(): List<TodoVo> {
        return todoDao.getAll()
    }

    override fun getById(id: Int): TodoVo? {
        return todoDao.findById(id)
    }

    override fun insert(todo: TodoVo) {
        todoDao.insert(todo)
    }

    override fun delete(todo: TodoVo) {
        todoDao.delete(todo)
    }

    override fun update(todo: TodoVo) {
        todoDao.update(todo)
    }

}