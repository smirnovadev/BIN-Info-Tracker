package com.example.bininfotracker.ui

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.core.text.isDigitsOnly
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bininfotracker.domain.api.HistoryCardInfoInteractor
import com.example.bininfotracker.domain.api.SearchCardInfoInteractor
import com.example.bininfotracker.domain.model.CardInfo
import kotlinx.coroutines.launch

class SearchViewModel(
    private val searchCardInfoInteractor: SearchCardInfoInteractor,
    private val historyCardInfoInteractor: HistoryCardInfoInteractor
) : ViewModel() {


    var bin: MutableState<String> = mutableStateOf("")
        private set

    var cardInfo = mutableStateOf<CardInfo?>(null)
        private set

    var isLoading = mutableStateOf(false)
        private set

    var errorMessage = mutableStateOf<String?>(null)
        private set
    var eventMessage = mutableStateOf<String?>(null)
        private set

    fun onBinChange(newBin: String) {
        bin.value = newBin
    }

    fun fetchCardInfo() {
        viewModelScope.launch {
            isLoading.value = true
            try {
                if (isValidBin(bin.value)) {
                    val info = searchCardInfoInteractor.getCardInfoByBin(bin.value)
                    Log.d("cardinfo", " to save: $info")
                    historyCardInfoInteractor.saveToHistory(info)
                    cardInfo.value = info
                    errorMessage.value = null
                    eventMessage.value = null
                } else {
                    eventMessage.value = "Введите 8 цифр вашего BIN"
                }
            } catch (e: Exception) {
                errorMessage.value = "Ошибка: ${e.message}"
            } finally {
                isLoading.value = false
            }
        }
    }

    fun isValidBin(bin: String): Boolean {
        return (bin.isDigitsOnly() && bin.length == 8)
    }

}
