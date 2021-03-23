package com.namu.todo.module

import com.namu.main.MainViewModel
import com.todo.addedit.AddEditViewModel
import org.koin.dsl.module

val featureModule = module {
    factory {
        MainViewModel(
            get()
        )
    }

    factory {
        AddEditViewModel(
            get()
        )
    }
}