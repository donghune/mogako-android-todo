package com.namu.localdb

import android.content.Context
import android.util.Log
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*

@RunWith(AndroidJUnit4::class)
class TodoDaoTest {

    private lateinit var defaultTodo: TodoVo
    private lateinit var todoDao: TodoDao
    private lateinit var todoDatabase: TodoDatabase

    @Before
    fun register() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        defaultTodo = createTodo(1)
        todoDatabase = Room.inMemoryDatabaseBuilder(context, TodoDatabase::class.java).build()
        todoDao = todoDatabase.getTodoDao()
    }

    @After
    fun unregister() {
        todoDatabase.close()
    }


    @Test
    fun test_getAll() {

        // given
        val todoList = listOf(createTodo(1), createTodo(2), createTodo(3))

        todoList.forEach { todoVo: TodoVo -> todoDao.insert(todoVo) }

        // when
        val allTodoList = todoDao.getAll()

        // then
        assert(allTodoList.size == 3)
        assert(allTodoList == todoList)

    }

    @Test
    fun test_update() {

        // given
        val updatedTitle = "test_update"
        todoDao.insert(defaultTodo)
        defaultTodo.title = updatedTitle

        // when
        todoDao.update(defaultTodo)


        // then
        val updatedTodo = todoDao.findById(defaultTodo.id)
        assert(updatedTodo != null)
        assert(updatedTodo!!.title == updatedTitle)

    }

    @Test
    fun test_insert() {

        // when
        todoDao.insert(defaultTodo)

        // then
        assert(todoDao.findById(defaultTodo.id) != null)

    }

    @Test
    fun test_delete() {

        // given
        todoDao.insert(defaultTodo)

        // when
        todoDao.delete(defaultTodo)

        // then
        assert(todoDao.findById(defaultTodo.id) == null)

    }

    private fun createTodo(id: Int): TodoVo {
        return TodoVo(
            id = id,
            title = "test_title",
            date = Date(),
            isUseReminder = false,
            isComplete = false,
        )
    }

}