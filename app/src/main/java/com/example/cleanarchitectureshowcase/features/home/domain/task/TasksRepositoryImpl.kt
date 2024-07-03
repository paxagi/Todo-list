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

    override suspend fun setTask(task: TaskDTO): TaskDTO {
        taskStorage.add(task)
        return task
    }

    override suspend fun updateTask(task: TaskDTO): TaskDTO {
        taskStorage[indexByID(task.id)] = task
        return getTask(task.id)
    }

    override suspend fun getTask(id: UUID): TaskDTO {
        return taskStorage[indexByID(id)]
    }

    override suspend fun getTasks(): List<TaskDTO> = taskStorage

    override suspend fun deleteTask(id: UUID) {
        taskStorage.removeAt(indexByID(id))
    }

    private fun indexByID(id: UUID): Int {
        taskStorage.let { tasks ->
            return tasks.indexOf(tasks.find { it.id == id })
        }
    }

}
