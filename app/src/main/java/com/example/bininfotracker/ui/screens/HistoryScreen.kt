package com.example.bininfotracker.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.bininfotracker.R
import com.example.bininfotracker.domain.model.CardInfo
import com.example.bininfotracker.ui.HistoryViewModel
import com.example.bininfotracker.ui.theme.Platinum
import com.example.bininfotracker.ui.theme.RaisinBlack

@Composable
fun HistoryScreen(
    viewModel: HistoryViewModel,
    paddingValues: PaddingValues
) {
    var historyCard by remember { mutableStateOf<List<CardInfo>>(emptyList()) }

    LaunchedEffect(Unit) {
        historyCard = viewModel.getHistoryCardInfo()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .background(Color.White)
    ) {
        if (historyCard.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(text = stringResource(R.string.no_query_history), color = RaisinBlack)
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(historyCard) { card ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        elevation = CardDefaults.cardElevation(4.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Platinum
                        )
                    ) {
                        Column(modifier = Modifier.padding(10.dp)) {
                            CardInfoDisplay(info = card)
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(15.dp))

            Button(
                onClick = {
                    viewModel.clearHistory()
                    historyCard = emptyList()
                },
                colors = ButtonDefaults.buttonColors(
                    contentColor = RaisinBlack,
                    containerColor = Platinum
                ),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 16.dp)
            ) {
                Text("Очистить историю")
            }
        }
    }
}
