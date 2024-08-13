package com.example.bininfotracker.data.network

import com.example.bininfotracker.data.dto.response.CardInfoDto
import retrofit2.http.GET
import retrofit2.http.Path

interface BnlistApi {
    @GET("/{bin}")
    suspend fun search(@Path("bin") bin: String): CardInfoDto
}