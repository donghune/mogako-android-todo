package com.namu.main

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.namu.common.entity.Todo
import com.namu.main.adapter.TodoAdapter
import com.namu.main.databinding.ActivityMainBinding
import org.koin.java.KoinJavaComponent.inject
import java.util.*
import kotlin.random.Random
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: TodoAdapter
    private val viewModel: MainViewModel by inject(MainViewModel::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        adapter = TodoAdapter()
        adapter.setOnClickListener {
            it.isComplete = !it.isComplete
            viewModel.completeTodo(it)
            viewModel.updateTodoList()
        }

        binding.recyclerTodoList.adapter = adapter
        binding.recyclerTodoList.layoutManager = LinearLayoutManager(this)
        binding.recyclerTodoList.setHasFixedSize(false)

        binding.buttonTodoCreate.setOnClickListener {
            viewModel.addTodo(
                Todo(
                    0,
                    "content${"%04d".format(Random.nextInt(1000))}",
                    Calendar.getInstance().time,
                    false,
                    isComplete = false
                )
            )
        }

        viewModel.todoList.observe(this, Observer { todoList: List<Todo> ->
            adapter.submitList(todoList)
            viewModel.updateTodoList()
        })

        setContentView(binding.root)
    }

    companion object {
        private val TAG = MainActivity::class.simpleName

        fun startActivity(context: Context) {
            context.startActivity(Intent(context, MainActivity::class.java))
        }
    }

}