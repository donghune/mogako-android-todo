package com.namu.data.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.namu.data.AppDataBase
import com.namu.data.PostDao
import com.namu.data.datasource.PostLocalDataSource
import com.namu.data.datasource.PostLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object DataDi {

    const val DATABASE_NAME="TODO"
    @Provides
    @Singleton
    fun provideRoomInstance(context: Application):AppDataBase{
        return Room.databaseBuilder(
            context,
            AppDataBase::class.java, DATABASE_NAME)
            .build()
    }


    @Provides
    @Singleton
    fun providePostDao(database:AppDataBase):PostDao{
        return database.getPostDao()
    }

    @Provides
    @Singleton
    fun provideDataSource(dao: PostDao):PostLocalDataSource{
        return PostLocalDataSourceImpl(dao)
    }

}