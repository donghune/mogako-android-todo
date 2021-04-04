package com.namu.todo.ui

import android.content.Context
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.namu.todo.R
import com.namu.todo.base.BaseFragment
import com.namu.todo.base.BaseObserverCollections
import com.namu.todo.databinding.FragmentPostWriteBinding
import com.namu.todo.ext.showToast
import com.nanum.presentation.HomeViewModelImpl
import com.nanum.presentation.PostWriteViewModelImpl
import com.nanum.presentation.ToolbarViewModelImpl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostWriteFragment : BaseFragment<FragmentPostWriteBinding>(R.layout.fragment_post_write) {

    private val mainViewModelImpl: HomeViewModelImpl by activityViewModels()
    private val postWriteViewModel: PostWriteViewModelImpl by viewModels()
    private val toolbarViewModel: ToolbarViewModelImpl by activityViewModels()


    override fun bindView() {
        binding.viewmodel = postWriteViewModel
    }

    override fun setObserver() {

        postWriteViewModel.postRegistResult
            .observe(viewLifecycleOwner, {
                mainViewModelImpl.onInsertPostingtrigger(it)
            })

        postWriteViewModel.msgForShow.observe(viewLifecycleOwner, Observer {
            context?.showToast(it)
        })

    }

    override fun initData() {
        resources.getString(R.string.title_post_write_toolbar).apply {
            toolbarViewModel.setTitle(this)
        }
    }
}


