package com.todo.addedit

import android.widget.EditText
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData

@BindingAdapter("bind:content")
fun bindContent(
    editText: EditText,
    content : () -> MutableLiveData<String>
) {

}