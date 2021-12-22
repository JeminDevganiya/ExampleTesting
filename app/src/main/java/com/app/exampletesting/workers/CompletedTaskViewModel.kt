package com.app.exampletesting.workers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.exampletesting.DataStoreRepository
import com.app.exampletesting.data.local.TaskData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CompletedTaskViewModel @Inject constructor(
    private val dataStoreRepository: DataStoreRepository
) : ViewModel() {

    private val _completeTask = MutableLiveData<List<TaskData>>()
    val completeTask: LiveData<List<TaskData>> = _completeTask

    fun getCompleteTask() {
        viewModelScope.launch {
            dataStoreRepository.getCompleteTask()
        }
    }
}
