package com.example.cleanarchitectureshowcase.features.home.data

import retrofit2.http.GET

interface ServerDataApi {

    @GET("test")
    suspend fun getSomeData(): DataDTO
}