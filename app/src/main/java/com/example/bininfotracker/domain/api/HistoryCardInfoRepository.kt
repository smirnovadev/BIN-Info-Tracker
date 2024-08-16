package com.example.bininfotracker.domain.api

import com.example.bininfotracker.domain.model.CardInfo

interface HistoryCardInfoRepository {
    fun saveToHistory(cardInfoList: List<CardInfo>)
    fun getCardInfoHistory(): List<CardInfo>
}