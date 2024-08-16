package com.example.bininfotracker.data

import android.content.SharedPreferences
import com.example.bininfotracker.domain.api.HistoryRepository
import com.example.bininfotracker.domain.model.CardInfo
import com.google.gson.Gson

class HistoryRepositoryImpl(
    private val sharedPref: SharedPreferences,
    private val gson: Gson,
) : HistoryRepository {
    override fun saveToHistory(cardInfoList: List<CardInfo>) {
        val newHistoryJson = gson.toJson(cardInfoList)
        sharedPref.edit()
            .putString(CARD_INFO, newHistoryJson)
            .apply()
    }

    override fun getCardInfoHistory(): List<CardInfo> {
        val historyJson = sharedPref.getString(CARD_INFO, null)
        return if (historyJson != null) {
            gson.fromJson(historyJson, Array<CardInfo>::class.java).toList()
        } else {
            emptyList()
        }
    }

    override fun clearHistory() {
        sharedPref.edit().clear().apply()
    }

    companion object {
        private const val CARD_INFO = "card_info"
    }
}