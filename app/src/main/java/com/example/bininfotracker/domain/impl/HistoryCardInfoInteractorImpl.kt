package com.example.bininfotracker.domain.impl

import com.example.bininfotracker.domain.api.HistoryCardInfoInteractor
import com.example.bininfotracker.domain.api.HistoryCardInfoRepository
import com.example.bininfotracker.domain.model.CardInfo

class HistoryCardInfoInteractorImpl(
    private val historyCardInfoRepository: HistoryCardInfoRepository
) :
    HistoryCardInfoInteractor {
    override fun saveToHistory(cardInfo: CardInfo) {
        val history = historyCardInfoRepository.getCardInfoHistory()
            .toMutableList()
            .apply { add(cardInfo) }
        historyCardInfoRepository.saveToHistory(history)
    }

    override fun getCardInfoHistory(): List<CardInfo> {
        return historyCardInfoRepository.getCardInfoHistory()
    }

}