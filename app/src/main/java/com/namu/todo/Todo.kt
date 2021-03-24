package com.namu.todo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo_table")
data class Todo(
        @PrimaryKey(autoGenerate = true) var id: Int,
        @ColumnInfo(name = "word") var todo: String
)
