package com.namu.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.namu.common.entity.Todo
import com.namu.main.databinding.ItemTodoBinding


class TodoAdapter : ListAdapter<Todo, TodoViewHolder>(DIFF_CALLBACK) {

    private var onClickListener: (Todo) -> Unit = {}
    private var onCheckBoxClickListener: (Todo) -> Unit = {}

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Todo>() {
            override fun areItemsTheSame(oldItem: Todo, newItem: Todo): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Todo, newItem: Todo): Boolean {
                return oldItem.isComplete == newItem.isComplete
            }
        }

        @JvmStatic
        @BindingAdapter("bind:item")
        fun bindItem(recyclerView: RecyclerView, todoList: LiveData<List<Todo>>?) {
            val adapter: TodoAdapter? = recyclerView.adapter as TodoAdapter?
            adapter?.submitList(todoList?.value ?: listOf())
        }
    }

    fun setOnClickListener(block: (Todo) -> Unit) {
        onClickListener = block
    }

    fun setOnCheckBoxClickListener(block: (Todo) -> Unit) {
        onCheckBoxClickListener = block
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
            setOnCheckBoxClickListener {
                onCheckBoxClickListener.invoke(it)
            }
        }
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}