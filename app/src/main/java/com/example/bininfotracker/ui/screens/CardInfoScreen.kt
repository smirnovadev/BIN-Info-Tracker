package com.example.bininfotracker.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.bininfotracker.R
import com.example.bininfotracker.domain.model.CardInfo
import com.example.bininfotracker.ui.CardInfoViewModel
import com.example.bininfotracker.ui.theme.CoolGray
import com.example.bininfotracker.ui.theme.Platinum
import com.example.bininfotracker.ui.theme.RaisinBlack

@Composable
fun CardInfoScreen(viewModel: CardInfoViewModel) {
    val bin by viewModel.bin
    val cardInfo by viewModel.cardInfo

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            value = bin,
            onValueChange = { viewModel.onBinChange(it) },
            placeholder = { Text(stringResource(R.string.placeholder_bin)) },
            textStyle = TextStyle(color = RaisinBlack),
            singleLine = true,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Platinum,
                unfocusedContainerColor = Platinum,
                focusedIndicatorColor = Platinum,
                unfocusedIndicatorColor = Platinum,

            ),
            modifier = Modifier
                .background(CoolGray, shape = RoundedCornerShape(16.dp))
                .padding(8.dp)
                .widthIn(max = 300.dp)
        )

        Button(onClick = { viewModel.fetchCardInfo() },
            colors = ButtonDefaults.buttonColors(
                contentColor = RaisinBlack,
                containerColor = Platinum
            ),
            modifier = Modifier.padding(top = 15.dp)) {
            Text(stringResource(R.string.get_information))
        }

        cardInfo?.let { info ->
            CardInfoDisplay(info)
        }
    }
}

@Composable
fun CardInfoDisplay(info: CardInfo) {
    Column {
        Text("Страна: ${info.countryName}",color = CoolGray)
        Text("Координаты: ${info.latitude}, ${info.longitude}")
        Text("Тип карты: ${info.scheme}")
        Text("Банк: ${info.bankName}")
        Text("Сайт банка: ${info.bankUrl}")
        Text("Телефон банка: ${info.bankPhone}")
        Text("Город банка: ${info.bankCity}")
    }
}