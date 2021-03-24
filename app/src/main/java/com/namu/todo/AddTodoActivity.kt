package com.namu.todo

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.asLiveData
import com.namu.todo.databinding.ActivityAddTodoBinding

class AddTodoActivity : BaseActivity<ActivityAddTodoBinding>(R.layout.activity_add_todo) {

    private val addTodoViewModel: AddTodoViewModel by viewModels {
        AddTodoViewModelFactory((application as TodoApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    fun addTodo(view: View) {
        val todo = binding.etTodo.text.toString()
        addTodoViewModel.insert(Todo(0, todo))
        finish()
    }
}