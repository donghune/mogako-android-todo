package com.namu.todo.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.namu.todo.domain.entity.Todo

@Database(entities = [Todo::class], version = 1, exportSchema = false)
abstract class TodoDatabase : RoomDatabase() {
    abstract fun todoDao(): TodoDao
}
