package com.todo.addedit

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.core.widget.doAfterTextChanged
import com.github.florent37.singledateandtimepicker.dialog.SingleDateAndTimePickerDialog
import com.namu.common.util.BaseActivity
import com.todo.addedit.databinding.ActivityAddEditBinding
import org.koin.java.KoinJavaComponent.inject
import java.util.*

class AddEditActivity : BaseActivity<ActivityAddEditBinding, AddEditViewModel>() {

    companion object {
        private const val TAG = "AddEditActivity"

        fun startActivity(context: Activity) {
            context.startActivity(Intent(context, AddEditActivity::class.java))
        }
    }

    override val viewModel: AddEditViewModel by inject(AddEditViewModel::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddEditBinding.inflate(layoutInflater)

        binding {
            toggleIsUseReminder.setOnCheckedChangeListener { _, isChecked ->
                viewModel.updateIsUseReminder(isChecked)
            }
            editContent.doAfterTextChanged {
                viewModel.updateContent(it.toString())
            }
            buttonAdd.setOnClickListener {
                viewModel.addTodo()
                finish()
            }
            buttonCalendar.setOnClickListener {
                SingleDateAndTimePickerDialog.Builder(this@AddEditActivity)
                    .title("Simple")
                    .listener { viewModel.updateDate(it) }
                    .display()
            }
            buttonClose.setOnClickListener {
                finish()
            }
        }

        setContentView(binding.root)
    }

}