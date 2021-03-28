package com.example.base

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseActivity<T : ViewDataBinding>(@LayoutRes private val resId: Int) :
    AppCompatActivity() {

    lateinit var binding: T
    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, resId)
        setObserver()
        viewBind()
        initData()
    }

    abstract fun viewBind()
    abstract fun setObserver()
    abstract fun initData()


    fun toastMsg(msg: Any?) {
        msg?.let {
            if (msg is Int) {
                Toast.makeText(this, getString(msg), Toast.LENGTH_SHORT).show()
                return
            }
            if (msg is String) {
                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun addDisposable(dispoasble:Disposable){
        compositeDisposable.add(
            dispoasble
        )
    }

    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }
}