package com.example.bininfotracker.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bininfotracker.domain.api.BinlistRepository
import com.example.bininfotracker.domain.model.CardInfo
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class CardInfoViewModel(private val repository: BinlistRepository) : ViewModel() {

    // Состояние для хранения введенного BIN
    var bin: MutableState<String> = mutableStateOf("")
        private set

    // Состояние для хранения информации о карте
    var cardInfo = mutableStateOf<CardInfo?>(null)
        private set

    // Состояние для управления загрузкой
    var isLoading = mutableStateOf(false)
        private set

    // Состояние для хранения сообщений об ошибках
    var errorMessage = mutableStateOf<String?>(null)
        private set

    // Метод для обновления BIN
    fun onBinChange(newBin: String) {
        bin.value = newBin
    }

    // Метод для запроса информации о карте по BIN
    fun fetchCardInfo() {
        viewModelScope.launch {
            isLoading.value = true
            try {
                // Запрос данных из репозитория
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
