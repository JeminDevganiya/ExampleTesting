package com.app.exampletesting.ui.other

import androidx.lifecycle.*
import com.app.exampletesting.DataStoreRepository
import com.app.exampletesting.data.local.TaskData
import kotlinx.coroutines.launch
import javax.inject.Inject

class TaskViewModel @Inject constructor(
    private val dataStoreRepository: DataStoreRepository

) : ViewModel() {

    val allUser: LiveData<List<TaskData>> = dataStoreRepository.getAll().asLiveData()

    fun getTaskData(){
        viewModelScope.launch {
            dataStoreRepository.getAll()
        }
    }
}
