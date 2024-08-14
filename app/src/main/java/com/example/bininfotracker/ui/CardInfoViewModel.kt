package com.example.bininfotracker.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bininfotracker.domain.api.BinlistRepository
import com.example.bininfotracker.domain.model.CardInfo
import kotlinx.coroutines.launch

class CardInfoViewModel(private val repository: BinlistRepository) : ViewModel() {


    var bin: MutableState<String> = mutableStateOf("")
        private set

    var cardInfo = mutableStateOf<CardInfo?>(null)
        private set

    var isLoading = mutableStateOf(false)
        private set

    var errorMessage = mutableStateOf<String?>(null)
        private set

    fun onBinChange(newBin: String) {
        bin.value = newBin
    }

    fun fetchCardInfo() {
        viewModelScope.launch {
            isLoading.value = true
            try {
                val info = repository.getCardInfoByBin(bin.value)
                cardInfo.value = info
                errorMessage.value = null
            } catch (e: Exception) {
                errorMessage.value = "Ошибка: ${e.message}"
            } finally {
                isLoading.value = false
            }
        }
    }
}
