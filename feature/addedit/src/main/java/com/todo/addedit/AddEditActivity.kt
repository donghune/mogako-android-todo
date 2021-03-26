package com.todo.addedit

import android.app.Activity
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.github.florent37.singledateandtimepicker.dialog.SingleDateAndTimePickerDialog
import com.namu.common.entity.Todo
import com.namu.common.util.BaseActivity
import com.todo.addedit.alarm.AlarmReceiver
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
                .listener { viewModel.date.value = it }
                .display()
        }

        binding.buttonClose.setOnClickListener {
            finish()
        }

        viewModel.viewState.observe(this@AddEditActivity) {
            when (it) {
                is AddEditViewState.SaveError -> {
                    Toast.makeText(this@AddEditActivity, it.message, Toast.LENGTH_SHORT).show()
                }
                is AddEditViewState.SaveSuccess -> {
                    if (it.todo.isUseReminder) {
                        registerAlarm(it.todo)
                    }
                    finish()
                }
                else -> {
                }
            }
        }

        setContentView(binding.root)

    }

    private fun registerAlarm(todo: Todo) {
        val alarmManager = this@AddEditActivity.getSystemService(ALARM_SERVICE) as AlarmManager
        alarmManager.set(
            AlarmManager.RTC_WAKEUP,
            todo.date.toDate().time + 2000,
            AlarmReceiver.getPendingIntent(this@AddEditActivity, todo)
        )
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