package com.example.cleanarchitectureshowcase.features.home.presentation

import com.example.cleanarchitectureshowcase.features.home.domain.PriorityLevel
import java.time.LocalDate

data class TaskUI(
    val header: String,
    val priority: PriorityLevel?,
    val deadline: LocalDate?,
    val isComplete: Boolean,
)