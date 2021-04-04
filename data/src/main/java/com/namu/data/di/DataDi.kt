package com.namu.data.di

import android.app.Application
import androidx.room.Room
import com.namu.data.AppDataBase
import com.namu.data.SharedPreferenceBase
import com.namu.data.dao.PostDao
import com.namu.data.datasource.PostLocalDataSource
import com.namu.data.datasource.PostLocalDataSourceImpl
import com.namu.data.datasource.SharedDataSource
import com.namu.data.datasource.SharedDataSourceImpl
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
    fun providePostDao(database:AppDataBase): PostDao {
        return database.getPostDao()
    }

    @Provides
    @Singleton
    fun provideDataSource(dao: PostDao):PostLocalDataSource{
        return PostLocalDataSourceImpl(dao)
    }

    @Provides
    @Singleton
    fun provideSharedInstance(context: Application):SharedPreferenceBase{
        return SharedPreferenceBase(context)
    }
    @Provides
    @Singleton
    fun provideSharedDataSource(preferenceBase: SharedPreferenceBase):SharedDataSource{
        return SharedDataSourceImpl(preferenceBase)
    }

}