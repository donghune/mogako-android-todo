package com.namu.todo.ui.list

import com.namu.todo.BR
import com.namu.todo.R
import com.namu.todo.databinding.ActivityListBinding
import com.namu.todo.util.android.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlin.reflect.KClass

@AndroidEntryPoint
class ListActivity : BaseActivity<ActivityListBinding, ListViewModel>() {
    override fun layoutResId(): Int = R.layout.activity_list
    override fun viewModelClass(): KClass<ListViewModel> = ListViewModel::class
    override fun viewModelVariableId(): Int = BR.vm
}
