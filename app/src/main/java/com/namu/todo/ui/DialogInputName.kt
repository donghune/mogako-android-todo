package com.namu.todo.ui

import com.namu.todo.R
import com.namu.todo.base.BaseDialogFragment
import com.namu.todo.databinding.DialogNicknameBinding
import com.namu.todo.ext.showToast

class DialogInputName() : BaseDialogFragment<DialogNicknameBinding>(R.layout.dialog_nickname) {
    override fun bindView() {
        isCancelable=false
    }

    var callback : ResultInputNickName?=null

    override fun setObserver() {
        binding.btnConfirm.setOnClickListener {
            binding.etInputName.text?.toString()?.let {
                if (it.isNotEmpty()) {
                    callback?.onResult(it)
                    dismiss()
                    return@setOnClickListener
                }
                context?.showToast("이름 입력해야만 이용할 수 있는뎅?")
            } ?: kotlin.run {
                context?.showToast("이름 입력해야만 이용할 수 있는뎅?")
            }
        }
    }

    override fun initData() {

    }


    companion object {
        fun newInstance(callBack :ResultInputNickName): DialogInputName {
            return DialogInputName().apply {
                callback=callBack
            }
        }
    }
}

interface ResultInputNickName {
    fun onResult(value: String?)
}