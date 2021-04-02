package com.namu.data

import androidx.room.Dao
import androidx.room.Insert
import com.example.entity.local.LocalDataPostModel

@Dao
interface PostDao {
     @Insert
     fun savePost(item:LocalDataPostModel)
}