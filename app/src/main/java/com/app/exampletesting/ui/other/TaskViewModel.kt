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

    private val _loading = MutableLiveData<Boolean>()
    val dataLoading: LiveData<Boolean> = _loading

    fun getTaskData(){
        _loading.value = true
        viewModelScope.launch {
            dataStoreRepository.getAll()
            _loading.value = false
        }
    }
}
