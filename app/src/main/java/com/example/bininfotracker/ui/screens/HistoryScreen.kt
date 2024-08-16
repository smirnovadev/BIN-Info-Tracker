package com.example.bininfotracker.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.bininfotracker.domain.model.CardInfo
import com.example.bininfotracker.ui.HistoryViewModel
import com.example.bininfotracker.ui.theme.Platinum

@Composable
fun HistoryScreen(viewModel: HistoryViewModel) {

    var historyCard by remember { mutableStateOf<List<CardInfo>>(emptyList()) }

    LaunchedEffect(Unit) {
        historyCard = viewModel.getHistoryCardInfo().take(100)
    }
    if (historyCard.isEmpty()) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "История запросов отсутствует")
        }
    } else {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(historyCard) { card ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    elevation = CardDefaults.cardElevation(4.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Platinum
                    )
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Страна: ${card.countryName}")
                        Text("Координаты: ${card.latitude}, ${card.longitude}")
                        Text("Тип карты: ${card.scheme}")
                        Text("Банк: ${card.bankName}")
                        Text("Сайт банка: ${card.bankUrl}")
                        Text("Телефон банка: ${card.bankPhone}")
                        Text("Город банка: ${card.bankCity}")
                    }
                }
            }
        }
    }
}
