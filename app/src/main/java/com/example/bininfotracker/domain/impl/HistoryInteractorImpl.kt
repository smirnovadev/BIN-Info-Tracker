package com.example.bininfotracker.domain.impl

import com.example.bininfotracker.domain.api.HistoryInteractor
import com.example.bininfotracker.domain.api.HistoryRepository
import com.example.bininfotracker.domain.model.CardInfo

class HistoryInteractorImpl(
    private val historyRepository: HistoryRepository
) :
    HistoryInteractor {
    override fun saveToHistory(cardInfo: CardInfo) {
        val history = historyRepository.getCardInfoHistory()
            .toMutableList()
            .apply { add(cardInfo) }
        historyRepository.saveToHistory(history)
    }

    override fun getCardInfoHistory(): List<CardInfo> {
        return historyRepository.getCardInfoHistory()
    }

    override fun clearHistory() {
        historyRepository.clearHistory()
    }

}