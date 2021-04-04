package com.namu.todo.ui

import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import com.namu.todo.R
import com.namu.todo.base.BaseDialogFragment
import com.namu.todo.databinding.DialogDeleteItemBinding

interface DialogDeleteCallback {
    fun onResult(pos: Int)
}

class DialogDeleteItem :
    BaseDialogFragment<DialogDeleteItemBinding>(R.layout.dialog_delete_item) {


    var callback: DialogDeleteCallback? = null
    var position: Int = 0
    override fun bindView() {

    }

    override fun setObserver() {
        binding.btnCancel.setOnClickListener {
            dismiss()
        }
        binding.btnConfirm.setOnClickListener {
            callback?.onResult(position)
            dismiss()
        }
    }

    override fun initData() {
        arguments?.get("data")?.let {
            position = it as Int
        }

    }

    companion object {
        fun newInstance(itemPos: Int, callback: DialogDeleteCallback): DialogDeleteItem {
            val fragment = DialogDeleteItem().apply {
                this.callback = callback
                arguments = bundleOf(
                    "data" to itemPos
                )
            }
            return fragment
        }
    }
}