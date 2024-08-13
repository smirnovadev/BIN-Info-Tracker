package com.example.bininfotracker.data

import com.example.bininfotracker.data.dto.request.BinlistInfoRequest
import com.example.bininfotracker.data.dto.response.CardInfoDto
import com.example.bininfotracker.domain.api.BinlistRepository
import com.example.bininfotracker.domain.mapper.CardMapper
import com.example.bininfotracker.domain.model.CardInfo

class BinlistRepositoryImpl(
    private val retrofitNetworkClient: NetWorkClient,
    private val cardMapper: CardMapper
) : BinlistRepository {
    override suspend fun getCardInfoByBin(bin: String): CardInfo {
        val binSearchRequest = BinlistInfoRequest(bin)
        val response = retrofitNetworkClient.doRequest(binSearchRequest)
        if (response.resultCode == 200) {
            val binlistResponse = response as CardInfoDto
            return cardMapper.map(binlistResponse)
        } else {
            throw Exception("Ошибка запроса: код ${response.resultCode}")
        }
    }
}