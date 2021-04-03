package com.nanum.presentation

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nanum.presentation.base.BaseViewModel
import com.nanum.presentation.base.SingleLiveEvent

interface ToolbarViewModle {
    fun setTitle(data: String?)
    fun onClickBackBtn()
    fun onClickSetting()
    fun setBackGroundColor(resId: Int)
}

class ToolbarViewModelImpl @ViewModelInject constructor() : BaseViewModel(), ToolbarViewModle {

    val livedatas: ToolbarLiveDataCollection by lazy {
        ToolbarLiveDataCollection()
    }

    override fun setTitle(data: String?) {
        livedatas.setTitle(data)
    }

    override fun onClickBackBtn() {
        livedatas.onClickBackBtn()
    }

    override fun onClickSetting() {
        livedatas.onClickSetting()
    }

    override fun setBackGroundColor(resId: Int) {
        livedatas.setBackGroundColor(resId)
    }
}


class ToolbarLiveDataCollection() : ToolbarViewModle {
    private val _title = MutableLiveData<String>()
    val title: LiveData<String>
        get() = _title

    private val _clickBackBtn = SingleLiveEvent<Boolean>()
    val clickBackBtn: LiveData<Boolean>
        get() = _clickBackBtn

    private val _clickSettingBtn = SingleLiveEvent<Boolean>()
    val clickSettingBtn: LiveData<Boolean>
        get() = _clickSettingBtn

    private val _backGroundColor = MutableLiveData<Int>()
    val backgroundColor: LiveData<Int>
        get() = _backGroundColor


    override fun setTitle(data: String?) {
        _title.value = data
    }

    override fun onClickBackBtn() {

    }

    override fun onClickSetting() {
        _clickSettingBtn.value = true
    }

    override fun setBackGroundColor(resId: Int) {
        _backGroundColor.value = resId
    }
}