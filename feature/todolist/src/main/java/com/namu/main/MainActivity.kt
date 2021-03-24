package com.namu.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.namu.common.entity.Todo
import com.namu.main.adapter.TodoAdapter
import com.namu.main.databinding.ActivityMainBinding
import org.koin.java.KoinJavaComponent.inject
import java.util.*
import kotlin.random.Random
import com.namu.common.util.BaseActivity
import com.todo.addedit.AddEditActivity

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override val viewModel: MainViewModel by inject(MainViewModel::class.java)
    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        todoAdapter = TodoAdapter().apply {
            setOnClickListener {
                it.isComplete = !it.isComplete
                viewModel.completeTodo(it)
                viewModel.updateTodoList()
            }
        }

        binding {
            recyclerTodoList.apply {
                adapter = todoAdapter
                layoutManager = LinearLayoutManager(this@MainActivity)
                setHasFixedSize(false)
            }

            buttonTodoCreate.setOnClickListener {
                AddEditActivity.startActivity(this@MainActivity)
                viewModel.updateTodoList()
            }
        }

        viewModel.todoList.observe(this, { todoList: List<Todo> ->
            todoAdapter.submitList(todoList)
        })

        viewModel.updateTodoList()

        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        viewModel.updateTodoList()
    }

    companion object {
        private val TAG = MainActivity::class.simpleName
    }

}