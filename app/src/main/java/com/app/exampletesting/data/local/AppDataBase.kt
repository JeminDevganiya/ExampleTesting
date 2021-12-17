package com.app.exampletesting.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert
    fun insert(taskData: TaskData)

    @Query("Select * From taskData")
    fun getAllUsers():Flow<List<TaskData>>

    @Query("UPDATE TaskData SET completed = :completed WHERE id = :taskId")
    suspend fun updateCompleted(taskId: String, completed: Boolean)
}
@Database(entities = [TaskData::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}