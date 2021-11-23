package com.app.exampletesting.di

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.exampletesting.ui.main.MyViewModelFactory
import com.app.exampletesting.ui.main.TaskViewModel
import com.app.exampletesting.ui.other.NewTaskViewModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap

@InstallIn(SingletonComponent::class)
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(TaskViewModel::class)
    abstract fun bindTaskViewModel(taskViewModel: TaskViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(NewTaskViewModel::class)
    abstract fun bindNewTaskViewModel(newTaskViewModel: NewTaskViewModel) : ViewModel

    @Binds
    abstract fun bindMyViewModelFactory(factory: MyViewModelFactory) : ViewModelProvider.Factory

}