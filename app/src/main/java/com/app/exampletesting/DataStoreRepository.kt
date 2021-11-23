package com.app.exampletesting

import com.app.exampletesting.data.local.TaskData
import com.app.exampletesting.data.local.UserDao
import javax.inject.Inject

interface DataStoreRepository {
    fun getAll() : kotlinx.coroutines.flow.Flow<List<TaskData>>
    fun insertTask(taskData: TaskData)
}
class DataStoreRepositoryImpl @Inject constructor(
    private val userDao: UserDao
) : DataStoreRepository {

    override fun getAll(): kotlinx.coroutines.flow.Flow<List<TaskData>> = userDao.getAllUsers()

    override fun insertTask(taskData: TaskData) = userDao.insert(taskData)
}