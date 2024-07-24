package com.example.cleanarchitectureshowcase.features.home.domain

import com.example.cleanarchitectureshowcase.core.domain.CoroutinesUseCase
import com.example.cleanarchitectureshowcase.features.home.presentation.DataUI
import javax.inject.Inject

class GetMockDataUsecase @Inject constructor(
    private val repository: DataRepository,
    private val businessLogicHelper: BusinessLogicHelper
): CoroutinesUseCase<String, List<DataUI>> {

    override suspend fun invoke(params: String): List<DataUI> {
        val serverData = repository.getData()
        val result = businessLogicHelper.doWork(serverData.toDomain())
        return result.toUI()
    }
}