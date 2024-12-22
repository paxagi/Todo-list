package com.example.cleanarchitectureshowcase.features.home.domain.task

import javax.inject.Inject

class HomeTaskServiceImpl @Inject constructor(
    private val repository: TasksRepository
) : HomeTaskService {
    override suspend fun add(task: DataTask) {
        repository.setTask(task.toDTO())
    }

    override suspend fun getTaskList(): List<DataTask> {
        return repository.getTasks().map { taskDTO ->
            val (id, header, priority, deadline, isComplete) = taskDTO
            DataTask(id, header, priority, deadline, isComplete)
        }
    }

    override suspend fun setStatus(task: DataTask, isComplete: Boolean) {
        update(task.copy(isComplete = isComplete))
    }

    override suspend fun update(task: DataTask) {
        return repository.updateTask(task.toDTO())
    }

    override suspend fun delete(task: DataTask) {
        repository.deleteTask(task.id)
    }

}
