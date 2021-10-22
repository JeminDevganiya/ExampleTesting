package com.app.exampletesting.data.local

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class TaskData(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "task_title") val taskTitle: String,
) : Parcelable
