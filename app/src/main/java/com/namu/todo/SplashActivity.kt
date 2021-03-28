package com.namu.todo

import com.example.base.BaseActivity
import com.example.base.makeLogD
import com.namu.todo.databinding.ActivitySplashBinding
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import java.util.*
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
                        makeLogD(it.localizedMessage)
                    }
                )
        )
    }

}