package com.namu.todo.bindinAdapter

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import com.nanum.presentation.ChangeType
import com.nanum.presentation.InputTextChaneListener


@BindingAdapter("bind:editTextListener","textType")
fun editTextListener(editText: EditText,listener: InputTextChaneListener,type:ChangeType){
    editText.addTextChangedListener(object:TextWatcher{
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        }

        override fun afterTextChanged(s: Editable?) {
            s?.let {
                listener.onChange(type,it.toString())
            }
        }

    })
}
