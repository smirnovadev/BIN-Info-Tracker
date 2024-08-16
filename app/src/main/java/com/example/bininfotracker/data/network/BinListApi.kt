package com.example.bininfotracker.data.network

import com.example.bininfotracker.data.dto.response.CardInfoDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface BinListApi {
    @Headers("Accept-Version: 3")
    @GET("/{bin}")
    suspend fun search(@Path("bin") bin: String): Response<CardInfoDto>
}