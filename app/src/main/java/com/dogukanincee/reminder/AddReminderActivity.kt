package com.dogukanincee.reminder

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.dogukanincee.reminder.databinding.AddReminderBinding

import java.util.*

class AddReminderActivity : AppCompatActivity() {

    private lateinit var binding: AddReminderBinding
    private lateinit var viewModel: ReminderViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AddReminderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[ReminderViewModel::class.java]

        binding.addReminderButton.setOnClickListener {
            val title = binding.reminderTitle.text.toString()
            val description = binding.reminderDescription.text.toString()
            val calendar = Calendar.getInstance()
            calendar.set(Calendar.HOUR_OF_DAY, binding.timePicker.currentHour)
            calendar.set(Calendar.MINUTE, binding.timePicker.currentMinute)
            calendar.set(Calendar.SECOND, 0)
            calendar.set(Calendar.MILLISECOND, 0)
            val time = calendar.timeInMillis

            val reminder = Reminder(0, title, description, time)
            viewModel.insert(reminder)

            finish()
        }
    }
}