package com.example.bininfotracker.domain.impl

import com.example.bininfotracker.domain.api.SearchInteractor
import com.example.bininfotracker.domain.api.SearchRepository
import com.example.bininfotracker.domain.model.CardInfo

class SearchInteractorImpl(
    private val searchRepository: SearchRepository
) : SearchInteractor {
    override suspend fun getCardInfoByBin(bin: String): CardInfo {
        return searchRepository.getCardInfoByBin(bin)
    }
}