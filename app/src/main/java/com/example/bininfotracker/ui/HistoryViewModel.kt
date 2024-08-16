package com.example.bininfotracker.ui

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.bininfotracker.domain.api.HistoryCardInfoInteractor
import com.example.bininfotracker.domain.model.CardInfo

class HistoryViewModel(
    private val historyCardInfoInteractor: HistoryCardInfoInteractor
): ViewModel() {
    fun getHistoryCardInfo(): List<CardInfo> {
        return historyCardInfoInteractor.getCardInfoHistory()
    }

}