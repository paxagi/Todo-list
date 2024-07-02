package com.example.cleanarchitectureshowcase.features.home.domain.task

import java.util.UUID

fun interface TaskAdder { suspend fun add(task: DataTask): DataTask }
fun interface TaskGetter { suspend fun getTask(id: UUID): DataTask }
fun interface TasksGetter { suspend fun getTaskList(): List<DataTask> }
fun interface TaskUpdater { suspend fun update(task: DataTask): DataTask }
interface TaskStatusSetter : TaskUpdater { suspend fun setStatus(task: DataTask, isComplete: Boolean): DataTask }
fun interface TaskRemover { suspend fun delete(task: DataTask) }