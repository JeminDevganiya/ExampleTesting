package com.app.exampletesting.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.exampletesting.databinding.RowTextBinding

class AllTaskAdapter : RecyclerView.Adapter<AllTaskAdapter.MyViewHolder>() {
    data class MyViewHolder(val binding: RowTextBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = RowTextBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.titleText.text =
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}