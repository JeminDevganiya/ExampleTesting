package com.app.exampletesting

import com.app.exampletesting.data.local.TaskData
import com.app.exampletesting.data.local.UserDao
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

interface DataStoreRepository {
    fun getAll() : kotlinx.coroutines.flow.Flow<List<TaskData>>
    fun insertTask(taskData: TaskData)
    suspend fun completeTask(taskData: TaskData)
    suspend fun completeTask(taskId: String)
    suspend fun activateTask(taskId: String)
    suspend fun activateTask(taskData: TaskData)
    suspend fun getCompleteTask(): List<TaskData>
}

class DataStoreRepositoryImpl @Inject constructor(
    private val userDao: UserDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : DataStoreRepository {

    override fun getAll(): kotlinx.coroutines.flow.Flow<List<TaskData>> = userDao.getAllUsers()

    override fun insertTask(taskData: TaskData) = userDao.insert(taskData)

    override suspend fun completeTask(taskData: TaskData) = withContext(ioDispatcher) {
        userDao.updateCompleted(taskData.id.toString(), true)
    }
    override suspend fun completeTask(taskId: String) {
        userDao.updateCompleted(taskId, true)
    }
    override suspend fun activateTask(taskData: TaskData) = withContext(ioDispatcher) {
        userDao.updateCompleted(taskData.id.toString(), false)
    }
    override suspend fun activateTask(taskId: String) {
        userDao.updateCompleted(taskId, false)
    }
    override suspend fun getCompleteTask():List<TaskData> = userDao.getCompleteTask()

}

