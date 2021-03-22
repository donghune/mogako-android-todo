package com.namu.todo.module

import com.namu.main.MainContract
import com.namu.main.MainPresenter
import com.todo.addedit.AddEditContract
import com.todo.addedit.AddEditPresenter
import org.koin.dsl.module

val featureModule = module {
    factory { (view: MainContract.View) ->
        MainPresenter(
            view,
            get()
        )
    }

    factory { (view: AddEditContract.View) ->
        AddEditPresenter(
            view,
            get()
        )
    }
}