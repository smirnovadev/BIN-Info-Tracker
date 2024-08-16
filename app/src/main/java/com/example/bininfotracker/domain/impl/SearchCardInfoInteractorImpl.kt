package com.example.bininfotracker.domain.impl

import com.example.bininfotracker.domain.api.SearchCardInfoInteractor
import com.example.bininfotracker.domain.api.SearchCardInfoRepository
import com.example.bininfotracker.domain.model.CardInfo

class SearchCardInfoInteractorImpl(
    private val searchCardInfoRepository: SearchCardInfoRepository
) : SearchCardInfoInteractor {
    override suspend fun getCardInfoByBin(bin: String): CardInfo {
        return searchCardInfoRepository.getCardInfoByBin(bin)
    }
}