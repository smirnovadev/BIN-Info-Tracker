package com.example.bininfotracker.data

import com.example.bininfotracker.data.dto.response.Response

interface NetWorkClient {
    suspend fun doRequest(dto: Any): Response
}