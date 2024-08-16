package com.example.bininfotracker.data.network

import com.example.bininfotracker.data.NetWorkClient
import com.example.bininfotracker.data.dto.request.Request
import com.example.bininfotracker.data.dto.response.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

class RetrofitNetworkClient
    (private val binListApi: BinListApi) : NetWorkClient {
    override suspend fun doRequest(dto: Any): Response {
        if (dto !is Request) {
            return Response().apply { resultCode = -1 }
        }
        return withContext(Dispatchers.IO) {
            try {
                val rawResponse = binListApi.search(dto.query)
                if (rawResponse.isSuccessful) {
                    val response = rawResponse.body() ?: Response()
                    response.apply { resultCode = 200 }
                } else {
                    Timber.e("Unknown error: response code ${rawResponse.code()}")
                    Response().apply { resultCode = rawResponse.code() }
                }
            } catch (exception: Exception) {
                Timber.e(exception.message ?: "Unknown error")
                Response().apply { resultCode = 500 }
            }
        }
    }

}