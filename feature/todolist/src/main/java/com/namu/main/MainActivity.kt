package com.namu.main

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.namu.common.entity.Todo
import com.namu.common.util.BaseActivity
import com.namu.main.adapter.TodoAdapter
import com.namu.main.databinding.ActivityMainBinding
import com.todo.addedit.AddEditActivity
import org.koin.java.KoinJavaComponent.inject

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override val layoutRedId: Int = R.layout.activity_main
    override val viewModel: MainViewModel by inject(MainViewModel::class.java)
    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.vm = viewModel

        todoAdapter = TodoAdapter().apply {
            setOnClickListener {
                AddEditActivity.startActivity(this@MainActivity, it)
            }
            setOnCheckBoxClickListener {
                it.isComplete = true
                viewModel.completeTodo(it)
                viewModel.updateTodoList()
            }
        }

        binding.recyclerTodoList.apply {
            adapter = todoAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(false)
        }

        binding.buttonTodoCreate.setOnClickListener {
            AddEditActivity.startActivity(this@MainActivity)
            viewModel.updateTodoList()
        }

        viewModel.todoList.observe(this, Observer { todoList: List<Todo> ->
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