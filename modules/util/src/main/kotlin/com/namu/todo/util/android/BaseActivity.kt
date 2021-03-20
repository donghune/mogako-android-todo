package com.namu.todo.util.android

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import kotlin.reflect.KClass

abstract class BaseActivity<B : ViewDataBinding, VM : BaseViewModel<*, *>> :
    AppCompatActivity() {

    protected lateinit var binding: B

    @LayoutRes
    protected abstract fun layoutResId(): Int?
    protected abstract fun viewModelClass(): KClass<VM>
    protected abstract fun viewModelVariableId(): Int?

    @Suppress("UNCHECKED_CAST")
    protected val vm: VM by lazy { ViewModelProvider(this)[viewModelClass().java] }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layoutResId = layoutResId() ?: return
        binding = DataBindingUtil.setContentView(this, layoutResId)

        binding.lifecycleOwner = this
        viewModelVariableId()?.let { id -> binding.setVariable(id, vm) }
    }
}
