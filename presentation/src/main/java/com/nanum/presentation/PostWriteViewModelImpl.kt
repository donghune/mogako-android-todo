package com.nanum.presentation

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.namu.domain.PostWriteUsecase
import com.nanum.presentation.base.BaseViewModel
import com.nanum.presentation.base.SingleLiveEvent
import com.nanum.presentation.base.isNotOrEmpty
import com.nanum.presentation.mapper.mapTo
import com.nanum.presentation.model.PresentPostModel
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class PostWriteViewModelImpl @ViewModelInject constructor(
    private val usecase: PostWriteUsecase
) : BaseViewModel(), InputTextChaneListener, PostWriteViewModel {

    val postLiveDataCollection = PostLiveDataCollection()


    override fun onChange(type: ChangeType, data: String) {
        when (type) {
            ChangeType.POST_WRITE_TITLE -> {
                postLiveDataCollection.setTitle(data)
            }
            ChangeType.POST_WRITE_CONTENTS -> {
                postLiveDataCollection.setContents(data)
            }
            else -> {

            }
        }

    }

    override fun onClickRegistBtn() {


        checkValueNotOrEmptyAndCreateModel()?.apply {
            this@PostWriteViewModelImpl(
                Single.just(this)
                    .subscribeOn(Schedulers.io())
                    .observeOn(Schedulers.computation())
                    .map {
                        it.mapTo()
                    }
                    .flatMap {
                        usecase.savePost(it)
                    }
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeBy(
                        onSuccess = {
                            setMsgForShow("${it}행 삽입 성공")

                        },
                        onError = {
                            setMsgForShow(it.localizedMessage)
                        }
                    )
            )
        }

        postLiveDataCollection.setPostRegistResult(true)

    }

    override fun checkValueNotOrEmptyAndCreateModel(): PresentPostModel? {
        val title = postLiveDataCollection.title.value
        val contenst = postLiveDataCollection.contents.value
        val registedDate = "test"
        val modifyDated = "test"
        val author = "익명 사용자"

        try {
            isNotOrEmpty(title, contenst, registedDate, modifyDated, author)
            return createPresentPostModel(
                title!!,
                contenst!!,
                registedDate,
                modifyDated,
                author!!
            )
        } catch (e: Exception) {
            setMsgForShow(e.localizedMessage)
        }
        return null
    }


    override fun createPresentPostModel(
        title: String, contents: String,
        registedDate: String, updatedDate: String, author: String
    ): PresentPostModel {
        return PresentPostModel(
            title = title,
            contents = contents,
            regestDate = registedDate,
            modifyDate = updatedDate,
            author = author
        )
    }
}


interface PostWriteViewModel {
    fun onClickRegistBtn()
    fun checkValueNotOrEmptyAndCreateModel(): PresentPostModel?
    fun createPresentPostModel(
        title: String, contents: String,
        registedDate: String, updatedDate: String, author: String,
    ): PresentPostModel
}


class PostLiveDataCollection {
    private val _title = MutableLiveData<String>()
    val title: LiveData<String>
        get() = _title

    private val _contents = MutableLiveData<String>()
    val contents: LiveData<String>
        get() = _contents


    private val _postRegistResult = SingleLiveEvent<Boolean>()
    val postRegistResult: LiveData<Boolean>
        get() = _postRegistResult


    fun setTitle(msg: String?) {
        msg?.let {
            _title.value = it
        }
    }

    fun setContents(msg: String?) {
        msg?.let {
            _contents.value = it
        }
    }

    fun setPostRegistResult(state: Boolean) {
        _postRegistResult.value = state
    }

}