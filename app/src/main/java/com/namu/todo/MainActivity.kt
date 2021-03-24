package com.namu.todo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.namu.todo.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val todoViewModel: TodoViewModel by viewModels {
        TodoViewModelFactory((application as TodoApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        todoViewModel.items.observe(this, Observer { todo ->
            todo?.let { todoViewModel.adapter.addData(it) }
        })
        binding.apply {
            viewModel = todoViewModel
            rvTodo.adapter = todoViewModel.adapter
        }
    }

    fun addTodo(view: View) {
        val nextIntent = Intent(this, AddTodoActivity::class.java)
        startActivity(nextIntent)
    }
}