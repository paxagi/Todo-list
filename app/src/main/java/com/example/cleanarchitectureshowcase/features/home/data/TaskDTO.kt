package com.example.cleanarchitectureshowcase.features.home.data

import com.example.cleanarchitectureshowcase.features.home.domain.task.DataTask
import com.example.cleanarchitectureshowcase.features.home.domain.PriorityLevel
import java.time.LocalDate
import java.util.UUID

data class TaskDTO(
    val id: UUID,
    val header: String,
    val priority: PriorityLevel?,
    val deadline: LocalDate?,
    val isComplete: Boolean,
) {
    fun toDomain() = DataTask(
        id, header, priority, deadline, isComplete
    )
}
