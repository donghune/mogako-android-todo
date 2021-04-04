package com.namu.todo.ui

import com.namu.todo.R
import com.namu.todo.base.BaseActivity
import com.namu.todo.databinding.ActivitySplashBinding
import com.namu.todo.ext.makeLog
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class SplashActivity : BaseActivity<ActivitySplashBinding>(R.layout.activity_splash) {
    override fun viewBind() {
        binding.lifecycleOwner = this
    }

    override fun setObserver() {
    }

    override fun initData() {
        setTimerSplash()
    }


    fun setTimerSplash() {
        addDisposable(
            Observable.timer(2, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                    onComplete = {
                        MainActivity.startActivitiy(this)
                        finish()
                    },
                    onError = {
                        makeLog("setTimerSplash",it.localizedMessage)
                    }
                )
        )
    }

}