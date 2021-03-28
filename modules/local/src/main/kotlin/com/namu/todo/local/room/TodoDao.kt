package com.namu.todo.local.room

import androidx.room.*
import com.namu.todo.domain.entity.Todo

@Dao
interface TodoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTodo(todo: Todo)

    @Query("SELECT * FROM todo ORDER BY date DESC")
    fun selectAllTodo(): List<Todo>

    @Query("SELECT * FROM todo WHERE id = :id")
    fun selectTodo(id: Int): Todo

    @Delete
    fun deleteTodo(todo: Todo)

    @Update
    fun updateTodo(todo: Todo)
}
