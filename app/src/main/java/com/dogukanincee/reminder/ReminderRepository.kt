package com.dogukanincee.reminder

import androidx.lifecycle.LiveData

class ReminderRepository(private val reminderDao: ReminderDao) {
    val allReminders: LiveData<List<Reminder>> = reminderDao.getAllReminders()

    suspend fun insert(reminder: Reminder) {
        reminderDao.insertReminder(reminder)
    }

    suspend fun delete(reminder: Reminder) {
        reminderDao.deleteReminder(reminder)
    }
}
