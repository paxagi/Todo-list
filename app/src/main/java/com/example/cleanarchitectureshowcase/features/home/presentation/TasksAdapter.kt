package com.example.cleanarchitectureshowcase.features.home.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitectureshowcase.R

class TasksAdapter(
    private var tasksList: List<DataUI>
) : RecyclerView.Adapter<TasksAdapter.TasksViewHolder>() {

    class TasksViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.tvTitle)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tasks, parent, false)
        return TasksViewHolder(view)
    }

    override fun getItemCount(): Int = tasksList.size

    override fun onBindViewHolder(holder: TasksViewHolder, position: Int) {
        holder.apply {
            this.title.text = tasksList[position].title
        }
    }

}
