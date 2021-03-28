package com.namu.todo.local

import android.content.Context
import androidx.room.Room
import com.namu.todo.local.room.TodoDao
import com.namu.todo.local.room.TodoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    fun provideDao(appDatabase: TodoDatabase): TodoDao = appDatabase.todoDao()

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): TodoDatabase {
        return Room.databaseBuilder(
            context,
            TodoDatabase::class.java,
            BuildConfig.DB_NAME
        ).build()
    }
}
