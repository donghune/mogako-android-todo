package com.namu.todo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo_table")
data class Todo(
        @PrimaryKey(autoGenerate = true) val id: Int,
        @ColumnInfo(name = "word") val todo: String
)
