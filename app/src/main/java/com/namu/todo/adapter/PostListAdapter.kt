package com.namu.todo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.namu.todo.databinding.ItemPostItemBinding
import com.nanum.presentation.model.PresentPostModel

class PostListAdapter :ListAdapter<PresentPostModel,PostItemViewHolder>(diffUtil){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostItemViewHolder {
        return PostItemViewHolder(
            ItemPostItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: PostItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    companion object{
        val diffUtil =object : DiffUtil.ItemCallback<PresentPostModel>(){
            override fun areItemsTheSame(
                oldItem: PresentPostModel,
                newItem: PresentPostModel
            ): Boolean {
                return oldItem==newItem
            }

            override fun areContentsTheSame(
                oldItem: PresentPostModel,
                newItem: PresentPostModel
            ): Boolean {
                return oldItem==newItem
            }

        }
    }

}


class PostItemViewHolder(
    private val binding : ItemPostItemBinding
):BaseViewHolder<ItemPostItemBinding,PresentPostModel>(binding){
    override fun bind(item: PresentPostModel) {
        binding.data=item
        binding.executePendingBindings()
    }

}