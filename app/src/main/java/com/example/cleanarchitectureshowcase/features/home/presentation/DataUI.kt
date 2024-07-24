package com.example.cleanarchitectureshowcase.features.home.presentation

import java.time.LocalDate

data class DataUI(
    val title: String,
    val subTitle: String,
    val description: String,
    val date: LocalDate?,
)