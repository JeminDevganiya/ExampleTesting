package com.app.exampletesting.ui.main

import android.widget.Toast
import androidx.lifecycle.*
import com.app.exampletesting.DataStoreRepository
import com.app.exampletesting.Event
import com.app.exampletesting.R
import com.app.exampletesting.data.local.TaskData
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val dataStoreRepository: DataStoreRepository

) : ViewModel() {

    val allUser: LiveData<List<TaskData>> = dataStoreRepository.getAll().asLiveData()

    private val _snackBarText = MutableLiveData<Lifecycle.Event<Int>>()
    val snackBarText: LiveData<Lifecycle.Event<Int>> = _snackBarText

    private fun showSnackBarMessage(message:Int){
        viewModelScope.launch {

        }
    }

    fun setCompleted(taskData: TaskData) = viewModelScope.launch {
        if (taskData.taskComplete) {
            dataStoreRepository.completeTask(taskData)
            showSnackBarMessage(R.string.task_marked_complete)
        } else {
            dataStoreRepository.activateTask(taskData)
            showSnackBarMessage(R.string.task_marked_active)

        }
    }
}
