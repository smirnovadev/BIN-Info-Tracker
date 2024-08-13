package com.example.bininfotracker.domain.api

import com.example.bininfotracker.domain.model.CardInfo

interface BinlistRepository {
    suspend fun getCardInfoByBin(bin: String): CardInfo
}