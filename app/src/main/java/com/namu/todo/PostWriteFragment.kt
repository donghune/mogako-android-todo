package com.namu.todo

import android.content.Context
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.namu.todo.base.BaseFragment
import com.namu.todo.base.BaseObserverCollections
import com.namu.todo.databinding.FragmentPostWriteBinding
import com.namu.todo.ext.showToast
import com.nanum.presentation.PostWriteViewModelImpl
import com.nanum.presentation.ToolbarViewModelImpl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostWriteFragment : BaseFragment<FragmentPostWriteBinding>(R.layout.fragment_post_write) {

    val postWriteViewModel: PostWriteViewModelImpl by viewModels()
    val toolbarViewModel : ToolbarViewModelImpl by activityViewModels()
    val observers: PostWriteObserverCollection by lazy {
        PostWriteObserverCollection(
            context, binding
        )
    }

    override fun bindView() {
        binding.viewmodel = postWriteViewModel
    }

    override fun setObserver() {

        postWriteViewModel.postLiveDataCollection.postRegistResult
            .observe(viewLifecycleOwner,observers.postResistObserver)


    }

    override fun initData() {
        resources.getString(R.string.title_post_write_toolbar).apply {
            toolbarViewModel.setTitle(this)
        }

        postWriteViewModel.msgForShow.observe(viewLifecycleOwner, Observer {
            context?.showToast(it)
        })

    }
}


class PostWriteObserverCollection(
    private val context: Context?,
    private val binding: ViewDataBinding
) :
    BaseObserverCollections<FragmentPostWriteBinding>(context, binding) {
    val postResistObserver = Observer<Boolean> {
        context?.showToast(R.string.msg_post_regist_succes)
    }

    val msgObserver = Observer<String>{
        context?.showToast(it)
    }
}