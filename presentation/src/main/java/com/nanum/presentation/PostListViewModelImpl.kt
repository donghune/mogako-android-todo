package com.nanum.presentation

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import com.namu.domain.usecase.PostReadUseCase
import com.nanum.presentation.base.BaseViewModel
import com.nanum.presentation.base.SingleLiveEvent
import com.nanum.presentation.mapper.mapTo
import com.nanum.presentation.model.PresentPostModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

interface PostListViewModel {
    fun setPostList(item: List<PresentPostModel>)
    fun getPostListAll()
}

class PostListViewModelImpl @ViewModelInject constructor(
    private val usecase: PostReadUseCase
) : BaseViewModel(), PostListViewModel {

    val postLivedataCollection: LoginLiveDataCollection by lazy {
        LoginLiveDataCollection()
    }

    init {
        getPostListAll()
    }

    override fun getPostListAll() {
        this(
            usecase.getPostListAll()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .map {
                    val result = ArrayList<PresentPostModel>()
                    it.map {
                        result.add(it.mapTo())
                    }
                    result
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                    onSuccess = {
                        setPostList(it)
                    },
                    onError = {
                        setMsgForShow(it.localizedMessage)
                    }
                )
        )
    }

    override fun setPostList(item: List<PresentPostModel>) {
        postLivedataCollection.setPostList(item)
    }


}


class LoginLiveDataCollection {

    private val _postList = SingleLiveEvent<List<PresentPostModel>>()
    val postList: LiveData<List<PresentPostModel>>
        get() = _postList


    fun setPostList(items: List<PresentPostModel>) {
        _postList.value = items
    }
}