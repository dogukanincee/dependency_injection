package com.dogukanincee.reminder

import ReminderViewModel
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class ReminderActivity : AppCompatActivity(), ReminderAdapter.OnReminderClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: ReminderViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ReminderAdapter(this)
        binding.reminderList.adapter = adapter

        viewModel = ViewModelProvider(this).get(ReminderViewModel::class.java)
        viewModel.allReminders.observe(this) { reminders ->
            adapter.submitList(reminders)
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
