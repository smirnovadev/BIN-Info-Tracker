package com.example.bininfotracker.domain.api

import com.example.bininfotracker.domain.model.CardInfo

interface HistoryCardInfoInteractor {
    fun saveToHistory(listCardInfo: CardInfo)
    fun getCardInfoHistory(): List<CardInfo>
}