package com.namu.localdb

import androidx.room.*

@Dao
interface TodoDao {

    @Query("SELECT * FROM todo ")
    fun getAll(): List<TodoVo>

    @Query("SELECT * FROM todo WHERE id = (:id)")
    fun findById(id : Int) : TodoVo?

    @Update
    fun update(todo: TodoVo)

    @Insert
    fun insert(todo : TodoVo)

    @Delete
    fun delete(todo: TodoVo)

}