package com.example.cleanarchitectureshowcase.features.home.domain.task

import com.example.cleanarchitectureshowcase.features.home.domain.DataDomain

interface BusinessLogicHelperTask {
    suspend fun doWork(params: DataTask): DataDomain
}