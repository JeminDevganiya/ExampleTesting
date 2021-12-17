package com.app.exampletesting.data.local

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.app.exampletesting.workers.CompletedFragment
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class TaskData(
    @PrimaryKey (autoGenerate = true)
    var id: Int,
    @ColumnInfo(name = "task_title") var taskTitle: String,
    @ColumnInfo(name = "description") var description: String,
    @ColumnInfo(name = "completed") var taskComplete : Boolean = false
) : Parcelable
