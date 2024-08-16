package com.example.bininfotracker.domain.api

import com.example.bininfotracker.domain.model.CardInfo

interface HistoryRepository {
    fun saveToHistory(cardInfoList: List<CardInfo>)
    fun getCardInfoHistory(): List<CardInfo>
    fun clearHistory()
}