package com.example.cleanarchitectureshowcase.features.home.domain

import com.example.cleanarchitectureshowcase.features.home.presentation.DataUI
import java.time.LocalDate

data class DataDomain(
    val title: String,
    val subTitle: String,
    val description: String,
    val importantDataForDomain: String,
) {
    fun toUI() = listOf(
            DataUI("Такса с дедлайном", "subTitle", "description", LocalDate.now()),
            DataUI("2222222222222222222222222222 222222222222222222222 " +
                    "22222222222222 2222222 222222222222222222222 2222222", "subTitle", "description", LocalDate.now()),
            DataUI("33333333", "subTitle", "description", LocalDate.now()),
            DataUI("44444444", "subTitle", "description", LocalDate.now()),
            DataUI("555555", "subTitle", "description", LocalDate.now()),
            DataUI("666666666", "subTitle", "description", LocalDate.now()),
            DataUI("7777777", "subTitle", "description", LocalDate.now()),
            DataUI("888888888", "subTitle", "description", LocalDate.now()),
            DataUI("999999", "subTitle", "description", LocalDate.now()),
        )
}
