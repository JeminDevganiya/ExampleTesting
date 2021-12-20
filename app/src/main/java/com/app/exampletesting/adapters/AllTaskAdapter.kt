package com.app.exampletesting.adapters

import android.R
import android.graphics.Paint
import android.text.Html
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.exampletesting.data.local.TaskData
import com.app.exampletesting.databinding.RowTextBinding


class AllTaskAdapter : RecyclerView.Adapter<AllTaskAdapter.MyViewHolder>() {

    data class MyViewHolder(val binding: RowTextBinding) : RecyclerView.ViewHolder(binding.root)

    var click: (TaskData) -> Unit = {}
    private val data: MutableList<TaskData> = mutableListOf()

    fun addTask(newTask: List<TaskData>) {
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
        holder.binding.allTaskCheckBox.setOnClickListener {
            click(data[position])
        }

        if (holder.binding.allTaskCheckBox.isChecked) {
            holder.binding.titleText.paintFlags = holder.binding.titleText.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }
    }

    override fun getItemCount(): Int = data.size
}