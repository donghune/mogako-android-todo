package com.namu.common.util

import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<B : ViewBinding, VM : BaseViewModel> : AppCompatActivity() {

    private lateinit var binding: B

    @LayoutRes
    protected abstract fun layoutResId(): Int?

}