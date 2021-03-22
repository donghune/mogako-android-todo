package com.namu.todo.module

import androidx.room.Room
import com.namu.localdb.TodoDatabase
import org.koin.dsl.module

val dataModule = module {
    single {
        Room.databaseBuilder(
            get(),
            TodoDatabase::class.java,
            "TodoDatabase"
        )
            .allowMainThreadQueries()
            .build()
    }

    single {
        get<TodoDatabase>().getTodoDao()
    }
}