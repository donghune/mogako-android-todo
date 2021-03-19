package com.namu.todo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.namu.todo.databinding.ItemTodoBinding


class TodoListAdapter() :RecyclerView.Adapter<TodoListAdapter.TodoViewHolder>() {
    private var dataSet: List<Todo> = listOf()

    fun addData(newData:List<Todo>) {
        dataSet = newData
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {

        val view = ItemTodoBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return TodoViewHolder(view)
    }


    override fun onBindViewHolder(viewHolder: TodoViewHolder, position: Int) {

        viewHolder.binding.item = dataSet[position]
    }

    override fun getItemCount() = dataSet.size

    class TodoViewHolder(var binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root)

}
