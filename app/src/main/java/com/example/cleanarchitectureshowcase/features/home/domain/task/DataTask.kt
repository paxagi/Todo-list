package com.example.cleanarchitectureshowcase.features.home.domain.task

import com.example.cleanarchitectureshowcase.features.home.data.TaskDTO
import com.example.cleanarchitectureshowcase.features.home.domain.PriorityLevel
import com.example.cleanarchitectureshowcase.features.home.presentation.TaskUI
import java.time.LocalDate
import java.util.UUID

data class DataTask(
    val id: UUID,
    val header: String,
    val priority: PriorityLevel?,
    val deadline: LocalDate?,
    val isComplete: Boolean,
) {
    fun toUI() = TaskUI(header, priority, deadline, isComplete)
    fun toDTO() = TaskDTO(id, header, priority, deadline, isComplete)
}
