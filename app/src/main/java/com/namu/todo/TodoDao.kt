package com.namu.todo

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TodoDao {
    @Query("SELECT * FROM todo")
    fun getAll(todo: List<Todo>)
    @Insert
    fun insertTodo(todo: Todo)
}