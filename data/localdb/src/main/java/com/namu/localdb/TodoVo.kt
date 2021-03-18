package com.namu.localdb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "todo")
data class TodoVo(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "date")
    var date: Date,

    @ColumnInfo(name = "is_use_reminder")
    var isUseReminder: Boolean = false,

    @ColumnInfo(name = "is_complete")
    var isComplete: Boolean = false
)