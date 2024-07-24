package com.example.cleanarchitectureshowcase.features.home.presentation

import android.graphics.Color
import android.os.Build
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.RelativeSizeSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitectureshowcase.R
import java.time.format.DateTimeFormatter


class TasksAdapter(
    private var tasksList: List<DataUI>
) : RecyclerView.Adapter<TasksAdapter.TasksViewHolder>() {

    class TasksViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.tvTitle)
        val icon: ImageView = itemView.findViewById(R.id.ivTaskIcon)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tasks, parent, false)
        return TasksViewHolder(view)
    }

    override fun getItemCount(): Int = tasksList.size

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: TasksViewHolder, position: Int) {
        holder.apply {
            val task = tasksList[position]
            val header: String = task.title
            val date: String = task.date?.format(DateTimeFormatter.ofPattern("dd MMMM yyyy")) ?: ""

            val spannableString = SpannableString("$header \n$date")

            spannableString.setSpan(
                RelativeSizeSpan(0.8f),
                header.length + 1,
                header.length + date.length+2,
                Spannable.SPAN_INCLUSIVE_INCLUSIVE,
            )
            spannableString.setSpan(
                ForegroundColorSpan(Color.GRAY),
                header.length + 1,
                header.length + date.length+2,
                Spannable.SPAN_INCLUSIVE_INCLUSIVE,
            )

            this.title.text = spannableString
            this.icon.setImageResource(R.drawable.ic_trash)
        }
    }

}
