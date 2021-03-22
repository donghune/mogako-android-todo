package com.namu.todo.module

import com.namu.todo.TodoDataSource
import com.namu.todo.TodoLocalDataSourceImpl
import com.namu.todo.TodoRepository
import org.koin.dsl.module

val domainModule = module {
    single<TodoDataSource> {
        TodoLocalDataSourceImpl(get())
    }

    single {
        TodoRepository(get())
    }
}