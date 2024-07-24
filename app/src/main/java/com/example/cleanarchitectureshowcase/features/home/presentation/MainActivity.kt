package com.example.cleanarchitectureshowcase.features.home.presentation

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitectureshowcase.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.time.LocalDate

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val viewModel: MainViewModel by viewModels()
    private lateinit var tasksRecyclerView: RecyclerView
    private lateinit var taskNotExist: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tasksRecyclerView = findViewById(R.id.tasks_recycler_view)
        taskNotExist = findViewById(R.id.task_not_exist)

        val tasksList: List<DataUI>? = viewModel.state.value


        lifecycleScope.launch {
            viewModel.someProccess()
            viewModel.state.collectLatest {data ->
                data?.let {
                    val adapter = TasksAdapter(it)
                    tasksRecyclerView.apply {
                        this.adapter = adapter
                        this.layoutManager = LinearLayoutManager(this@MainActivity)
                    }
                } ?: {
                    taskNotExist.text = "Задач нет..." //TODO: установить отображение
                }
            }
        }
    }
}