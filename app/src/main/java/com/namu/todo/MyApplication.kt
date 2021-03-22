package com.namu.todo

import android.app.Application
import com.namu.todo.module.dataModule
import com.namu.todo.module.domainModule
import com.namu.todo.module.featureModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                listOf(
                    dataModule,
                    domainModule,
                    featureModule
                )
            )
            androidContext(this@MyApplication)
        }
    }

}