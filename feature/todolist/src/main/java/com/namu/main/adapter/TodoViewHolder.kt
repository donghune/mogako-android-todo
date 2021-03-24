package com.namu.main.adapter

import androidx.recyclerview.widget.RecyclerView
import com.namu.common.entity.Todo
import com.namu.main.databinding.ItemTodoBinding


class TodoViewHolder(
    private val viewBinding: ItemTodoBinding
) : RecyclerView.ViewHolder(
    viewBinding.root
) {

    private var onCheckBoxClickListener: (Todo) -> Unit = {}

    fun setOnCheckBoxClickListener(block: (todo: Todo) -> Unit) {
        onCheckBoxClickListener = block
    }

    fun bind(todo: Todo) {
        viewBinding.todo = todo
        viewBinding.checkboxIsComplete.setOnClickListener { onCheckBoxClickListener.invoke(todo) }
        viewBinding.executePendingBindings()
    }

}