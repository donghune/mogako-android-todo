package com.namu.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.entity.local.LocalDataPostModel
import com.namu.data.dao.PostDao

@Database(entities = [LocalDataPostModel::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun getPostDao(): PostDao
}