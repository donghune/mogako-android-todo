package com.namu.todo.base

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.lifecycleScope
import com.namu.todo.BR
import com.namu.todo.util.android.BaseActivity
import com.namu.todo.util.android.ViewCommand
import com.namu.todo.util.android.observeEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

abstract class BaseActivity<B : ViewDataBinding, VM : BaseViewModel<VC, *>, VC : ViewCommand> :
    BaseActivity<B, VM>() {
    override fun viewModelVariableId(): Int = BR.vm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        observeViewModel()
    }

    protected open fun observeViewModel() {
        if (vm is NoViewModel) {
            return
        }
        observeEvent(vm.event) { command -> observeCommand(command) }
        observeEvent(vm.error) {
//            Alert.Error(this, primaryButton = ::finish).show()
        }
    }

    protected open fun observeCommand(command: VC) = Unit

    protected fun <T> Flow<T>.launchIn(coroutineScope: CoroutineScope = lifecycleScope): Job =
        coroutineScope.launch {
            catch { vm.onError(it) }.collect()
        }
}
