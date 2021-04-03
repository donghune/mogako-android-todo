package com.namu.todo.observer

import android.content.Context
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.namu.todo.adapter.PostListAdapter
import com.namu.todo.base.BaseObserverCollections
import com.namu.todo.databinding.FragmentPostListBinding
import com.nanum.presentation.model.PresentPostModel

class PostListObserverCollection(
    private val context: Context?,
    private val binding: ViewDataBinding
) : BaseObserverCollections<FragmentPostListBinding>(context, binding) {

    val postListObserver = fun(adapter : PostListAdapter): Observer<List<PresentPostModel>> {
       return Observer<List<PresentPostModel>> {
            //fragment.findNavController().navigate(R.id.action_to_PostWrite)
           adapter.submitList(it)
        }
    }


}