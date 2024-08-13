package com.example.bininfotracker.data.network

import com.example.bininfotracker.data.NetWorkClient
import com.example.bininfotracker.data.dto.request.BinlistInfoRequest
import com.example.bininfotracker.data.dto.response.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

class RetrofitNetworkClient
    (private val binlistApi: BnlistApi) : NetWorkClient {
    override suspend fun doRequest(dto: Any): Response {
        if (dto !is BinlistInfoRequest) {
            return Response().apply { resultCode = -1 }
        }
        return withContext(Dispatchers.IO) {
            try {
                val response = binlistApi.search(dto.query)
                response.apply { resultCode = 200 }
            } catch (exception: Exception) {
                Timber.e(exception.message ?: "Unknown error")
                Response().apply { resultCode = 500 }
            }
        }
    }

}