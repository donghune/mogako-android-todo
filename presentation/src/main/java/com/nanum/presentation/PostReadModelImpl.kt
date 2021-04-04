package com.nanum.presentation

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import com.namu.domain.repository.PostDeleteUseCase
import com.namu.domain.usecase.PostReadUseCase
import com.nanum.presentation.base.BaseViewModel
import com.nanum.presentation.base.SingleLiveEvent
import com.nanum.presentation.mapper.mapTo
import com.nanum.presentation.model.PresentPostModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

interface PostReadViewModel {
    fun setPostList(item: ArrayList<PresentPostModel>)
    fun getPostListAll()
    fun postDeleteFromLocal(pos: Int)
    fun notifyDeleteItem(pos: Int)
    fun deleteItemFromList(pos: Int)
    fun addItemAfterRegist(item: PresentPostModel)
}

class PostReadModelImpl @ViewModelInject constructor(
    private val usecase: PostReadUseCase,
    private val deleteUsecase: PostDeleteUseCase
) : BaseViewModel(), PostReadViewModel {


    private val _resultOnDeletePost = SingleLiveEvent<Int>()
    val resultOnDeletePost: LiveData<Int>
        get() = _resultOnDeletePost


    private val _postList = SingleLiveEvent<ArrayList<PresentPostModel>>()
    val postList: LiveData<ArrayList<PresentPostModel>>
        get() = _postList


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

    override fun postDeleteFromLocal(pos: Int) {
        postList.value?.let {
            this(
                deleteUsecase.deletePostEach(it[pos].mapTo())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeBy(
                        onSuccess = {
                            setMsgForShow("${it}행을 성공적으로 삭제했습니다")
                            deleteItemFromList(it)
                        },
                        onError = {
                            setMsgForShow(it.localizedMessage)
                        }
                    )
            )
        }

    }

    override fun notifyDeleteItem(pos: Int) {
        _resultOnDeletePost.value = pos
    }

    override fun deleteItemFromList(pos: Int) {
        postList.value?.let {
            it.removeAt(pos)
            notifyDeleteItem(pos)
        }
    }

    override fun addItemAfterRegist(item: PresentPostModel) {
        _postList.value?.let {
            it.add(item)
            _postList.value = it
        }
    }

    override fun setPostList(items: ArrayList<PresentPostModel>) {
        _postList.value = items
    }


}

