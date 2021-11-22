package com.app.exampletesting.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.exampletesting.data.local.TaskData
import com.app.exampletesting.databinding.RowTextBinding
import com.app.exampletesting.ui.other.NewTask

class AllTaskAdapter : RecyclerView.Adapter<AllTaskAdapter.MyViewHolder>() {

    data class MyViewHolder(val binding: RowTextBinding) : RecyclerView.ViewHolder(binding.root)

    private val data: MutableList<TaskData> = mutableListOf()

    fun getTask(newTask: List<TaskData>) {
        data.addAll(newTask)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = RowTextBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.titleText.text = data[position].taskTitle
    }

    override fun getItemCount(): Int = data.size
}