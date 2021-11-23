package com.app.exampletesting.ui.other

import androidx.lifecycle.*
import com.app.exampletesting.DataStoreRepository
import com.app.exampletesting.data.local.TaskData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


class NewTaskViewModel @Inject constructor(

    private val dataStoreRepository: DataStoreRepository

) : ViewModel() {

    private val _insertFinish = MutableLiveData<Unit>()
    val insertFinish: LiveData<Unit> = _insertFinish

    fun insertTaskData(taskData: TaskData) {
        viewModelScope.launch {
            dataStoreRepository.insertTask(taskData)
            _insertFinish.value = Unit
        }
    }
}