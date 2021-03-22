package com.namu.main.adapter

import androidx.recyclerview.widget.RecyclerView
import com.namu.common.entity.Todo
import com.namu.main.databinding.ItemTodoBinding
import java.text.SimpleDateFormat
import java.util.*


class TodoViewHolder(
    itemView: ItemTodoBinding
) : RecyclerView.ViewHolder(itemView.root) {

    private val isComplete = itemView.checkboxIsComplete
    private val content = itemView.textContent
    private val leftDate = itemView.textLeftDate

    fun bind(todo: Todo) {
        isComplete.isChecked = todo.isComplete
        content.text = todo.content
        leftDate.text = calculateLeftDate(todo)
    }

    private fun calculateLeftDate(todo: Todo): String {
        val today = Calendar.getInstance()
        val todoDate = (today.clone() as Calendar).apply { time = todo.date }

        return when (val dayDiff =
            todoDate.get(Calendar.DAY_OF_MONTH) - today.get(Calendar.DAY_OF_MONTH)) {
            0 -> "today"
            1 -> "tomorrow"
            else -> {
                if (dayDiff < 0) {
                    "overdue"
                } else {
                    SimpleDateFormat("yyyy-MM-dd", Locale.KOREA).format(todoDate)
                }
            }
        }
    }

}