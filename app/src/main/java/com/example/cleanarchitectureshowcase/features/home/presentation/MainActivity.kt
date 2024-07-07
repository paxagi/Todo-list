package com.example.cleanarchitectureshowcase.features.home.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitectureshowcase.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val viewModel: MainViewModel by viewModels()
    private lateinit var tasksRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tasksRecyclerView = findViewById(R.id.tasks_recycler_view)

        val tasksList: List<DataUI> =
//            viewModel.state
            listOf(
                DataUI("title1", "subTitle", "description"),
                DataUI("title2", "subTitle", "description"),
                DataUI("title3", "subTitle", "description"),
                DataUI("title4", "subTitle", "description"),
                DataUI("title5", "subTitle", "description"),
                DataUI("title6", "subTitle", "description"),
                DataUI("title7", "subTitle", "description"),
            )
        val adapter = TasksAdapter(tasksList)
        tasksRecyclerView.apply {
            this.adapter = adapter
            this.layoutManager = LinearLayoutManager(this@MainActivity)
        }

        lifecycleScope.launch {
            viewModel.someProccess()
            viewModel.state.collectLatest {data ->

            }
        }
    }
}