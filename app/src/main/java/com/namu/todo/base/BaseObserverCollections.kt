package com.namu.todo.base

import android.content.Context
import androidx.databinding.ViewDataBinding

abstract class BaseObserverCollections<T:ViewDataBinding>(
    private val context: Context?,
    private val binding : ViewDataBinding
)