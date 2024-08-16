package com.example.bininfotracker.domain.api

import com.example.bininfotracker.domain.model.CardInfo

interface HistoryInteractor {
    fun saveToHistory(listCardInfo: CardInfo)
    fun getCardInfoHistory(): List<CardInfo>
    fun clearHistory()
}