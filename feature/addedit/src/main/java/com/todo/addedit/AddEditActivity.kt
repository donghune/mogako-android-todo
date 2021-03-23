package com.todo.addedit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.todo.addedit.databinding.ActivityAddEditBinding
import org.koin.core.parameter.parametersOf
import org.koin.java.KoinJavaComponent.inject

class AddEditActivity : AppCompatActivity(R.layout.activity_add_edit) {

    private lateinit var binding: ActivityAddEditBinding
    private val viewModel by inject(AddEditViewModel::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}