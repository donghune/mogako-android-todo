package com.todo.addedit

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.core.widget.doAfterTextChanged
import com.github.florent37.singledateandtimepicker.dialog.SingleDateAndTimePickerDialog
import com.namu.common.entity.Todo
import com.namu.common.util.BaseActivity
import com.todo.addedit.databinding.ActivityAddEditBinding
import org.koin.java.KoinJavaComponent.inject
import java.util.*

class AddEditActivity : BaseActivity<ActivityAddEditBinding, AddEditViewModel>() {

    override val layoutRedId: Int = R.layout.activity_add_edit
    override val viewModel: AddEditViewModel by inject(AddEditViewModel::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val beforeTodo: Todo? = intent.getParcelableExtra("todo")

        binding.vm = viewModel
        beforeTodo?.let { viewModel.onTodoLoaded(it) }

        binding.buttonAdd.setOnClickListener {
            viewModel.saveTodo()
        }

        binding.buttonCalendar.setOnClickListener {
            SingleDateAndTimePickerDialog.Builder(this@AddEditActivity)
                .title("Simple")
                .defaultDate(viewModel.date.value ?: Date())
                .listener { it }
                .display()
        }

        binding.buttonClose.setOnClickListener {
            finish()
        }

        setContentView(binding.root)

    }

    companion object {
        fun startActivity(context: Activity, todo: Todo? = null) {
            context.startActivity(
                Intent(context, AddEditActivity::class.java).putExtra(
                    "todo",
                    todo
                )
            )
        }
    }

}