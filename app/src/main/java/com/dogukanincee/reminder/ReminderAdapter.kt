package com.dogukanincee.reminder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dogukanincee.reminder.databinding.AddReminderBinding
import java.text.SimpleDateFormat
import java.util.*

class ReminderAdapter(private val listener: OnReminderClickListener) :
    ListAdapter<Reminder, ReminderAdapter.ReminderViewHolder>(DiffCallback()) {

    interface OnReminderClickListener {
        fun onReminderClick(reminder: Reminder)
    }

    class ReminderViewHolder(private val binding: AddReminderBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(reminder: Reminder, listener: OnReminderClickListener) {
            binding.reminderTitle.text = reminder.title
            binding.reminderDescription.text = reminder.description
            val formattedTime = SimpleDateFormat.getTimeInstance().format(Date(reminder.time))
            binding.reminderTime.text = formattedTime
            binding.root.setOnClickListener {
                listener.onReminderClick(reminder)
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Reminder>() {
        override fun areItemsTheSame(oldItem: Reminder, newItem: Reminder): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Reminder, newItem: Reminder): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReminderViewHolder {
        val binding =
            AddReminderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ReminderViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReminderViewHolder, position: Int) {
        val reminder = getItem(position)
        holder.bind(reminder, listener)
    }
}