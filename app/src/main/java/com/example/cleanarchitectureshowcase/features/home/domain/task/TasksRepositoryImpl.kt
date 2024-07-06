package com.example.cleanarchitectureshowcase.features.home.domain.task

import com.example.cleanarchitectureshowcase.features.home.data.TaskDTO
import com.example.cleanarchitectureshowcase.features.home.domain.PriorityLevel
import java.util.LinkedList
import java.util.UUID

class TasksRepositoryImpl : TasksRepository {
    private val taskStorage: LinkedList<TaskDTO> = listOf(
        TaskDTO(UUID.randomUUID(), "one", PriorityLevel.HIGH, null, false),
        TaskDTO(UUID.randomUUID(), "two", null, null, false),
        TaskDTO(UUID.randomUUID(), "3", PriorityLevel.LOW, null, false),
        TaskDTO(UUID.randomUUID(), "four", null, null, false),
        TaskDTO(UUID.randomUUID(), "five", null, null, false),
    ).let { LinkedList<TaskDTO>(it) }

    override suspend fun setTask(task: TaskDTO) {
        taskStorage.add(task)
    }

    override suspend fun updateTask(task: TaskDTO) {
        var linkToUpdatedTask = taskStorage.find { it.id == task.id }
        linkToUpdatedTask = task
    }

    override suspend fun getTask(id: UUID): TaskDTO? = taskStorage.firstOrNull { it.id == id }

    override suspend fun getTasks(): List<TaskDTO> = taskStorage

    override suspend fun deleteTask(id: UUID) {
            taskStorage.removeAt(taskStorage.indexOfFirst { it.id == id })
    }

}
