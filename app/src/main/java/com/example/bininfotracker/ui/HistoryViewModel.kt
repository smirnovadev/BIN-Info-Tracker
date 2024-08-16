package com.example.bininfotracker.ui

import androidx.lifecycle.ViewModel
import com.example.bininfotracker.domain.api.HistoryInteractor
import com.example.bininfotracker.domain.model.CardInfo

class HistoryViewModel(
    private val historyInteractor: HistoryInteractor
): ViewModel() {
    fun getHistoryCardInfo(): List<CardInfo> {
        return historyInteractor.getCardInfoHistory()
    }

    fun clearHistory() {
        historyInteractor.clearHistory()
    }
}