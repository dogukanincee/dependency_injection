package com.dogukanincee.reminder

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.dogukanincee.reminder.databinding.ActivityReminderBinding

class ReminderActivity : AppCompatActivity(), ReminderAdapter.OnReminderClickListener {

    private lateinit var binding: ActivityReminderBinding
    private lateinit var viewModel: ReminderViewModel
    private var adapter: ReminderAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReminderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = ReminderAdapter(this)
        binding.reminderList.adapter = adapter

        viewModel = ViewModelProvider(this)[ReminderViewModel::class.java]
        viewModel.allReminders.observe(this) { reminders ->
            adapter!!.submitList(reminders)
        }

        binding.addReminderButton.setOnClickListener {
            val intent = Intent(this, AddReminderActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onReminderClick(reminder: Reminder) {
        // Handle click on reminder item
    }
}
