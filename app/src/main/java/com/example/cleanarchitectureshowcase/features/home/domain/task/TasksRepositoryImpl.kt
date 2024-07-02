package com.example.cleanarchitectureshowcase.features.home.domain.task

import com.example.cleanarchitectureshowcase.features.home.data.TaskDTO
import com.example.cleanarchitectureshowcase.features.home.domain.PriorityLevel
import java.util.UUID

class TasksRepositoryImpl : TasksRepository {
    private val taskStorage: MutableList<TaskDTO> = mutableListOf(
        TaskDTO(UUID.randomUUID(), "one", PriorityLevel.HIGH, null, false),
        TaskDTO(UUID.randomUUID(), "two", null, null, false),
        TaskDTO(UUID.randomUUID(), "3", PriorityLevel.LOW, null, false),
        TaskDTO(UUID.randomUUID(), "four", null, null, false),
        TaskDTO(UUID.randomUUID(), "five", null, null, false),
    )

    override suspend fun setTask(task: TaskDTO): TaskDTO {
        taskStorage.add(task)
        return task
    }

    override suspend fun updateTask(task: TaskDTO): TaskDTO {
        TODO("Not yet implemented")
    }

    override suspend fun getTask(id: UUID): TaskDTO {
        TODO("Not yet implemented")
    }

    override suspend fun getTasks(): List<TaskDTO> = taskStorage

    override suspend fun deleteTask(id: UUID) {
        TODO("Not yet implemented")
    }

    suspend fun findTask(id: UUID): TaskDTO {
        TODO("Not yet implemented")
    }

}
