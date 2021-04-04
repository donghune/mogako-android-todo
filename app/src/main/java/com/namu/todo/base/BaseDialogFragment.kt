package com.namu.todo.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseDialogFragment<T : ViewDataBinding>(@LayoutRes private val resId: Int) : DialogFragment(){

    lateinit var binding: T
    private val compositeDisposable = CompositeDisposable()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, resId, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObserver()
        bindView()
        setViewModelLifecycle()
        initData()
    }

   abstract fun bindView()
    abstract fun setObserver()
    abstract fun initData()


    fun setViewModelLifecycle(){
        binding.lifecycleOwner=this
    }

    fun toastMsg(msg: Any?) {
        msg?.let {
            if (msg is Int) {
                Toast.makeText(context, getString(msg), Toast.LENGTH_SHORT).show()
                return
            }
            if (msg is String) {
                Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
            }
        }
    }
    fun addDisposable(dispoasble: Disposable){
        compositeDisposable.add(
            dispoasble
        )
    }

    override fun onDestroyView() {
        compositeDisposable.clear()
        super.onDestroyView()
    }
}

