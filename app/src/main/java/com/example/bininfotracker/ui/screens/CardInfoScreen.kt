package com.example.bininfotracker.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun CardInfoScreen() {
    var bin by remember { mutableStateOf("") }
    var country by remember { mutableStateOf("Страна:") }
    var cardType by remember { mutableStateOf("Тип карты:") }
    var bankName by remember { mutableStateOf("Банк:") }
    var bankUrl by remember { mutableStateOf("URL:") }
    var bankPhone by remember { mutableStateOf("Телефон:") }
    var bankCity by remember { mutableStateOf("Город:") }
    var coordinates by remember { mutableStateOf("Координаты:") }

    // Общий стиль для всех текстовых элементов
    val textStyle = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        textAlign = TextAlign.Start
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TextField(
            value = bin,
            onValueChange = { bin = it },
            label = { Text("Введите BIN") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val newCountry = "Россия"
                val newCardType = "Visa"
                val newBankName = "Сбербанк"
                val newBankUrl = "www.sberbank.ru"
                val newBankPhone = "+7 800 555 55 50"
                val newBankCity = "Москва"
                val newCoordinates = "55.751244, 37.618423"

                updateCardInfo(
                    country = newCountry,
                    cardType = newCardType,
                    bankName = newBankName,
                    bankUrl = newBankUrl,
                    bankPhone = newBankPhone,
                    bankCity = newBankCity,
                    coordinates = newCoordinates
                ) { updatedCountry, updatedCardType, updatedBankName, updatedBankUrl, updatedBankPhone, updatedBankCity, updatedCoordinates ->
                    country = updatedCountry
                    cardType = updatedCardType
                    bankName = updatedBankName
                    bankUrl = updatedBankUrl
                    bankPhone = updatedBankPhone
                    bankCity = updatedBankCity
                    coordinates = updatedCoordinates
                }
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Найти")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Применение общего стиля ко всем текстовым элементам
        Text(text = country, style = textStyle, modifier = Modifier.padding(vertical = 4.dp))
        Text(text = cardType, style = textStyle, modifier = Modifier.padding(vertical = 4.dp))
        Text(text = bankName, style = textStyle, modifier = Modifier.padding(vertical = 4.dp))
        Text(text = bankUrl, style = textStyle, modifier = Modifier.padding(vertical = 4.dp))
        Text(text = bankPhone, style = textStyle, modifier = Modifier.padding(vertical = 4.dp))
        Text(text = bankCity, style = textStyle, modifier = Modifier.padding(vertical = 4.dp))
        Text(text = coordinates, style = textStyle, modifier = Modifier.padding(vertical = 4.dp))
    }
}

fun updateCardInfo(
    country: String,
    cardType: String,
    bankName: String,
    bankUrl: String,
    bankPhone: String,
    bankCity: String,
    coordinates: String,
    onUpdate: (
        country: String,
        cardType: String,
        bankName: String,
        bankUrl: String,
        bankPhone: String,
        bankCity: String,
        coordinates: String
    ) -> Unit
) {
    onUpdate(
        country = "Страна: $country",
        cardType = "Тип карты: $cardType",
        bankName = "Банк: $bankName",
        bankUrl = "URL: $bankUrl",
        bankPhone = "Телефон: $bankPhone",
        bankCity = "Город: $bankCity",
        coordinates = "Координаты: $coordinates"
    )
}