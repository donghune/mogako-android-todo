package com.namu.todo.ui

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.namu.todo.R
import com.namu.todo.adapter.PostListAdapter
import com.namu.todo.base.BaseFragment
import com.namu.todo.databinding.DialogDeleteItemBinding
import com.namu.todo.databinding.FragmentPostReadBinding
import com.namu.todo.observer.PostListObserverCollection
import com.nanum.presentation.HomeViewModelImpl
import com.nanum.presentation.PostListViewModelImpl
import com.nanum.presentation.PostReadModelImpl
import com.nanum.presentation.ToolbarViewModelImpl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostReadFragment : BaseFragment<FragmentPostReadBinding>(R.layout.fragment_post_read),
    DialogDeleteCallback {

    val postReadViewModel: PostReadModelImpl by viewModels()
    val postListViewModel: PostListViewModelImpl by viewModels()
    val homeViewModelImpl: HomeViewModelImpl by activityViewModels()
    val toolbarViewModel: ToolbarViewModelImpl by activityViewModels()

    val adapter: PostListAdapter by lazy {
        PostListAdapter(postListViewModel)
    }
    private val observers: PostListObserverCollection by lazy {
        PostListObserverCollection(
            context,
            binding
        )
    }

    override fun bindView() {
        binding.viewmodel = postReadViewModel
        binding.adapter = adapter
    }

    override fun setObserver() {
        homeViewModelImpl.insertPostingTrigger.observe(viewLifecycleOwner, Observer {
                postReadViewModel.addItemAfterRegist(it)
        })

        postReadViewModel.postList.observe(
            viewLifecycleOwner,
            observers.postListObserver(adapter)
        )

        postListViewModel.clickShowDialog.observe(viewLifecycleOwner, Observer {

            DialogDeleteItem.newInstance(it, this)
                .also {
                    it.show(childFragmentManager, it.javaClass.simpleName)
                }
        })

        postReadViewModel.resultOnDeletePost.observe(viewLifecycleOwner, Observer {
            adapter.notifyItemRemoved(it)
        })


    }

    override fun initData() {
        resources.getString(R.string.title_post_read_toolbar).apply {
            toolbarViewModel.setTitle(this)
        }
    }

    override fun onResult(pos: Int) {
        postReadViewModel.postDeleteFromLocal(pos)
    }


}