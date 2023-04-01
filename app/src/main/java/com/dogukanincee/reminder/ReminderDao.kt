package com.dogukanincee.reminder

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ReminderDao {
    @Query("SELECT * FROM Reminder")
    fun getAllReminders(): LiveData<List<Reminder>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertReminder(reminder: Reminder)

    @Delete
    suspend fun deleteReminder(reminder: Reminder)
}
