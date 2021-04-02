package com.nanum.presentation.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel : ViewModel() {

    val compositeDisposable by lazy {
        CompositeDisposable()
    }

    private val _msgForShow = SingleLiveEvent<Any>()
    val msgForShow: LiveData<Any>
        get() = _msgForShow


    operator fun invoke(observable: Disposable) {
        compositeDisposable.add(observable)
    }

    operator fun invoke(vararg observable: Disposable) {
        compositeDisposable.addAll(*observable)
    }


    fun setMsgForShow(data: Any) {
        _msgForShow.value = data
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}