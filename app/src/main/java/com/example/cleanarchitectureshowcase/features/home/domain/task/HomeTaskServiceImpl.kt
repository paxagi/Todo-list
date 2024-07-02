package com.example.cleanarchitectureshowcase.features.home.domain.task

import javax.inject.Inject

class HomeTaskServiceImpl @Inject constructor(
    private val repository: TasksRepository
) : HomeTaskService {
    override suspend fun add(task: DataTask): DataTask {
        return repository.setTask(task.toDTO()).toDomain()
    }

    override suspend fun getTaskList(): List<DataTask> {
        return repository.getTasks().map { taskDTO ->
            val (id, header, priority, deadline, isComplete) = taskDTO
            DataTask(id, header, priority, deadline, isComplete)
        }
    }

    override suspend fun setStatus(task: DataTask, isComplete: Boolean): DataTask {
        return update(task.copy(isComplete = isComplete))
    }

    override suspend fun update(task: DataTask): DataTask {
        return repository.updateTask(task.toDTO()).toDomain()
    }

    override suspend fun delete(task: DataTask) {
        repository.deleteTask(task.id)
    }

}
