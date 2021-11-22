package com.app.exampletesting.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert
    fun insert(taskData: TaskData)

    @Query("Select * From taskData")
    fun getAllUsers():Flow<List<TaskData>>
}
@Database(entities = [TaskData::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}