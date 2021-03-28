package com.namu.todo.di

import com.namu.todo.domain.repository.TodoRepository
import com.namu.todo.repository.TodoRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    @Singleton
    fun bindTodoRepo(repo: TodoRepositoryImpl): TodoRepository
}
