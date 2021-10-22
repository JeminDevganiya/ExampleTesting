package com.app.exampletesting.data.local

import androidx.room.*

@Dao
interface UserDao {
    @Insert
    fun insert(taskData: TaskData)

    @Query("Select * From taskData")
    fun getAllUsers():List<TaskData>
}
@Database(entities = [TaskData::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}