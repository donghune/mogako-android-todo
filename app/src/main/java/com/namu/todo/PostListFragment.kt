package com.namu.todo

import androidx.fragment.app.viewModels
import com.namu.todo.adapter.PostListAdapter
import com.namu.todo.base.BaseFragment
import com.namu.todo.databinding.FragmentPostListBinding
import com.namu.todo.observer.PostListObserverCollection
import com.nanum.presentation.PostListViewModelImpl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostListFragment : BaseFragment<FragmentPostListBinding>(R.layout.fragment_post_list) {

    val postListViewModel: PostListViewModelImpl by viewModels()
    val adapter: PostListAdapter by lazy {
        PostListAdapter()
    }
    private val observers: PostListObserverCollection by lazy {
        PostListObserverCollection(
            context,
            binding
        )
    }

    override fun bindView() {
        binding.viewmodel = postListViewModel
        binding.adapter = adapter
    }

    override fun setObserver() {
        postListViewModel.postLivedataCollection.postList.observe(
            viewLifecycleOwner,
            observers.postListObserver(adapter)
        )


    }

    override fun initData() {
    }


}