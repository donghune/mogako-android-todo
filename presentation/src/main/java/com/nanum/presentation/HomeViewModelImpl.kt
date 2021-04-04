package com.nanum.presentation

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.namu.domain.usecase.SharedUseCase
import com.namu.domain.usecase.SharedUseCaseImpl
import com.nanum.presentation.base.BaseViewModel
import com.nanum.presentation.base.SingleLiveEvent
import com.nanum.presentation.model.PresentPostModel
import com.nanum.presentation.utils.SHARED_TAG_USERNAME
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.SchedulerRunnableIntrospection
import io.reactivex.schedulers.Schedulers

class HomeViewModelImpl @ViewModelInject constructor(
    private val sharedUseCase: SharedUseCase
) : BaseViewModel(), HomeViewModel {
    private val _insertPostingTrigger = SingleLiveEvent<PresentPostModel>()
    val insertPostingTrigger: LiveData<PresentPostModel>
        get() = _insertPostingTrigger


    private val _userNickName = SingleLiveEvent<String>()
    val userNickName: LiveData<String>
        get() = _userNickName


    init {
        getUserName()
    }

    override fun onInsertPostingtrigger(item: PresentPostModel) {
        _insertPostingTrigger.value = item
    }

    override fun saveUserName(value: String) {
        this(
            Single.just(sharedUseCase.setUserNickName(SHARED_TAG_USERNAME, value))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                    onSuccess = {
                        setMsgForShow("성공")
                    },
                    onError = {
                        setMsgForShow(it.localizedMessage)
                    }
                )


        )
    }

    override fun checkUserNickName() {
        this(
            sharedUseCase.getUserNickName(SHARED_TAG_USERNAME)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                    onSuccess = {

                    },
                    onError = {
                        setMsgForShow(it.localizedMessage)
                    }
                )
        )
    }

    override fun setUserNickName(value: String?) {
        value?.let {
            _userNickName.value = it
            saveUserName(it)
        }
    }

    override fun getUserName() {
        this(
            sharedUseCase.getUserNickName(SHARED_TAG_USERNAME)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                    onSuccess = {
                        _userNickName.value = it
                    },
                    onError = {
                        setMsgForShow(it.localizedMessage)
                    }
                )
        )

    }
}

interface HomeViewModel {
    fun onInsertPostingtrigger(item: PresentPostModel)
    fun checkUserNickName()
    fun setUserNickName(value: String?)
    fun saveUserName(value: String)
    fun getUserName()
}