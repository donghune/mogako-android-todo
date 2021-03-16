package com.namu.localdb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "todo")
data class TodoVO(
    @PrimaryKey val id: Int,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "description")
    val description: String,

    @ColumnInfo(name = "priority")
    val priority: Int,

    @ColumnInfo(name = "start_date")
    val startDate: Date,

    @ColumnInfo(name = "end_date")
    val endDate: Date,

    @ColumnInfo(name = "is_notify_alarm")
    val isNotifyAlarm: Boolean = false,

    @ColumnInfo(name = "is_clear")
    val isClear: Boolean = false
)