package com.namu.todo.ui.list

import com.namu.todo.R
import com.namu.todo.base.BaseActivity
import com.namu.todo.databinding.ActivityListBinding
import com.namu.todo.util.android.NoViewCommand
import dagger.hilt.android.AndroidEntryPoint
import kotlin.reflect.KClass

@AndroidEntryPoint
class ListActivity : BaseActivity<ActivityListBinding, ListViewModel, NoViewCommand>() {
    override fun layoutResId(): Int = R.layout.activity_list
    override fun viewModelClass(): KClass<ListViewModel> = ListViewModel::class
}
