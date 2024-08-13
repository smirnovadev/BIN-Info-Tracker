package com.example.bininfotracker.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.example.bininfotracker.domain.model.CardInfo
import com.example.bininfotracker.ui.CardInfoViewModel

@Composable
fun CardInfoScreen(viewModel: CardInfoViewModel) {
    val bin by viewModel.bin
    val cardInfo by viewModel.cardInfo

    Column {
        TextField(
            value = bin,
            onValueChange = { viewModel.onBinChange(it) },
            label = { Text("Введите BIN") }
        )

        Button(onClick = { viewModel.fetchCardInfo() }) {
            Text("Получить информацию")
        }

        cardInfo?.let { info ->
            CardInfoDisplay(info)
        }
    }
}

@Composable
fun CardInfoDisplay(info: CardInfo) {
    Column {
        Text("Страна: ${info.countryName}")
        Text("Координаты: ${info.latitude}, ${info.longitude}")
        Text("Тип карты: ${info.cardType}")
        Text("Банк: ${info.bankName}")
        Text("Сайт банка: ${info.bankUrl}")
        Text("Телефон банка: ${info.bankPhone}")
        Text("Город банка: ${info.bankCity}")
    }
}