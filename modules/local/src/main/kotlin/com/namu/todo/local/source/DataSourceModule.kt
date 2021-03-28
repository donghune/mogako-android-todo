package com.namu.todo.local.source

import com.namu.todo.source.TodoLocalDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class DataSourceModule {

    @Binds
    @Singleton
    abstract fun bindTodoLocalDataSource(dataDataSourceImpl: TodoLocalDataSourceImpl): TodoLocalDataSource
}
