package com.example.cleanarchitectureshowcase.features.home.domain.task

import com.example.cleanarchitectureshowcase.features.home.data.TaskDTO
import java.util.UUID

interface TasksRepository {
    suspend fun setTask(task: TaskDTO): TaskDTO
    suspend fun updateTask(task: TaskDTO): TaskDTO
    suspend fun getTask(id: UUID): TaskDTO
    suspend fun getTasks(): List<TaskDTO>
    suspend fun deleteTask(id: UUID)
}