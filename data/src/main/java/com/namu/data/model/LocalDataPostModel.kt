package com.example.entity.local

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class LocalDataPostModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val contents: String,
    val registDate: String,
    val modifyDate: String,
    val author: String,
    val readCount: Int,
    val likeCount: Int,
    val disLikeCount: Int
)