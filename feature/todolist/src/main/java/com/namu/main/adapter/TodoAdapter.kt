package com.namu.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.namu.common.entity.Todo
import com.namu.main.databinding.ItemTodoBinding

class TodoAdapter : ListAdapter<Todo, TodoViewHolder>(DIFF_CALLBACK) {

    private var onClickListener: (Todo) -> Unit = {}

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Todo>() {
            override fun areItemsTheSame(oldItem: Todo, newItem: Todo): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Todo, newItem: Todo): Boolean {
                return oldItem.isComplete == newItem.isComplete
            }
        }
    }

    fun setOnClickListener(block: (Todo) -> Unit) {
        onClickListener = block
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
            ItemTodoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        ).apply {
            setOnClickListener {
                onClickListener.invoke(it)
            }
        }
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}