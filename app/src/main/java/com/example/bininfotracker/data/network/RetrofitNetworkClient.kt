package com.example.bininfotracker.data.network

import android.util.Log
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
                val rawResponse = binlistApi.search(dto.query)
                Log.d("cardinfo", "Response body: ${rawResponse.raw()?.body()?.string()}")
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