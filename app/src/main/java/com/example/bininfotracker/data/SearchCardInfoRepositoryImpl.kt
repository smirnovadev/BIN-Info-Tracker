package com.example.bininfotracker.data

import android.util.Log
import com.example.bininfotracker.data.dto.request.BinlistInfoRequest
import com.example.bininfotracker.data.dto.response.CardInfoDto
import com.example.bininfotracker.domain.api.SearchCardInfoRepository
import com.example.bininfotracker.domain.mapper.CardMapper
import com.example.bininfotracker.domain.model.CardInfo

class SearchCardInfoRepositoryImpl(
    private val retrofitNetworkClient: NetWorkClient,
    private val cardMapper: CardMapper
) : SearchCardInfoRepository {
    override suspend fun getCardInfoByBin(bin: String): CardInfo {
        val binSearchRequest = BinlistInfoRequest(bin)
        val response = retrofitNetworkClient.doRequest(binSearchRequest)
        if (response.resultCode == 200) {
            val binlistResponse = response as CardInfoDto
            Log.d("cardinfo", " to save: $binlistResponse")
            return cardMapper.map(binlistResponse)
        } else {
            throw Exception("Ошибка запроса: код ${response.resultCode}")
        }
    }
}