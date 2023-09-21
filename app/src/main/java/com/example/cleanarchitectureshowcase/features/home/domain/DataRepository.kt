package com.example.cleanarchitectureshowcase.features.home.domain

import com.example.cleanarchitectureshowcase.features.home.data.DataDTO

interface DataRepository {
    suspend fun getData(): DataDTO
}