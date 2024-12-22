package com.example.cleanarchitectureshowcase.features.home.domain

import com.example.cleanarchitectureshowcase.core.domain.CoroutinesUseCase
import javax.inject.Inject

class GetMockDataUsecase @Inject constructor(
    private val repository: DataRepository,
    private val businessLogicHelper: BusinessLogicHelper
): CoroutinesUseCase<String, DataDomain> {

    override suspend fun invoke(params: String): DataDomain {
        val serverData = repository.getData()
        val result = businessLogicHelper.doWork(serverData.toDomain())
        return result
    }
}