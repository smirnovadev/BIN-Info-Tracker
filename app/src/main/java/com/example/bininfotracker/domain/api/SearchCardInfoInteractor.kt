package com.example.bininfotracker.domain.api

import com.example.bininfotracker.domain.model.CardInfo

interface SearchCardInfoInteractor {
    suspend fun getCardInfoByBin(bin: String): CardInfo
}