package com.app.exampletesting.ui.main

import androidx.lifecycle.*
import com.app.exampletesting.DataStoreRepository
import com.app.exampletesting.data.local.TaskData
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
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
