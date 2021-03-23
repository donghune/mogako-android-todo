package com.todo.addedit

import android.os.Bundle
import com.namu.common.util.BaseActivity
import com.todo.addedit.databinding.ActivityAddEditBinding
import org.koin.java.KoinJavaComponent.inject

class AddEditActivity : BaseActivity<ActivityAddEditBinding, AddEditViewModel>() {

    override val viewModel: AddEditViewModel by inject(AddEditViewModel::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}