package com.nanum.presentation

import androidx.lifecycle.LiveData
import com.nanum.presentation.base.BaseViewModel
import com.nanum.presentation.base.SingleLiveEvent


interface PostListViewModel {
    fun onClickShowDialog(pos:Int)
}

class PostListViewModelImpl : BaseViewModel(),PostListViewModel {

    private val _clickShowDialog = SingleLiveEvent<Int>()
    val clickShowDialog: LiveData<Int>
        get() = _clickShowDialog


    override fun onClickShowDialog(pos:Int) {
        _clickShowDialog.value = pos
    }
}