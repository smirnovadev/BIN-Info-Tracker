package com.example.bininfotracker.data

import com.example.bininfotracker.data.dto.request.Request
import com.example.bininfotracker.data.dto.response.CardInfoDto
import com.example.bininfotracker.domain.api.SearchRepository
import com.example.bininfotracker.domain.mapper.CardMapper
import com.example.bininfotracker.domain.model.CardInfo

class SearchRepositoryImpl(
    private val retrofitNetworkClient: NetWorkClient,
    private val cardMapper: CardMapper
) : SearchRepository {
    override suspend fun getCardInfoByBin(bin: String): CardInfo {
        val binSearchRequest = Request(bin)
        val response = retrofitNetworkClient.doRequest(binSearchRequest)
        if (response.resultCode == 200) {
            val binlistResponse = response as CardInfoDto
            return cardMapper.map(binlistResponse)
        } else {
            throw Exception("Ошибка запроса: код ${response.resultCode}")
        }
    }
}