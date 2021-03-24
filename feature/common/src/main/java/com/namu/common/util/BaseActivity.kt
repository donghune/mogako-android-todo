package com.namu.common.util

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel

abstract class BaseActivity<T : ViewDataBinding, VM : ViewModel> : AppCompatActivity() {

    protected abstract val layoutRedId: Int
    lateinit var binding: T
    protected abstract val viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, layoutRedId)
        binding.lifecycleOwner = this@BaseActivity
    }

}