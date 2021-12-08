package com.app.exampletesting.di

import android.content.Context
import androidx.room.Room
import com.app.exampletesting.data.local.AppDatabase
import com.app.exampletesting.data.local.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DataBaseModule {
    @Provides
    fun providesUserDao(appDataBase: AppDatabase): UserDao {
        return appDataBase.userDao()
    }

    @Provides
    @Singleton
    fun providesAppDataBase(@ApplicationContext appContext: Context):
            AppDatabase {
        return Room.databaseBuilder(
            appContext, AppDatabase::class.java, "User"
        ).allowMainThreadQueries().build()
    }
}