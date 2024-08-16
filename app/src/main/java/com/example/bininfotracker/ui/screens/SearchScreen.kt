package com.example.bininfotracker.ui.screens

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.bininfotracker.R
import com.example.bininfotracker.domain.model.CardInfo
import com.example.bininfotracker.ui.SearchViewModel
import com.example.bininfotracker.ui.theme.CoolGray
import com.example.bininfotracker.ui.theme.Platinum
import com.example.bininfotracker.ui.theme.RaisinBlack

@Composable
fun CardInfoScreen(viewModel: SearchViewModel) {
    val bin by viewModel.bin
    val cardInfo by viewModel.cardInfo
    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            keyboardActions = KeyboardActions(
                onDone = {
                    keyboardController?.hide()
                }
            ),
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
        Button(
            onClick = {
                viewModel.fetchCardInfo()
                val message = viewModel.eventMessage.value
                message?.let {
                    Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
                    viewModel.eventMessage.value = null
                }
                keyboardController?.hide()
            },
            colors = ButtonDefaults.buttonColors(
                contentColor = RaisinBlack,
                containerColor = Platinum
            ),
            modifier = Modifier.padding(top = 15.dp)
        ) {
            Text(stringResource(R.string.get_information))
        }

        cardInfo?.let { info ->
            CardInfoDisplay(info)
        }

    }
}

@Composable
fun CardInfoDisplay(info: CardInfo) {
    val context = LocalContext.current

    Column(
        modifier = Modifier.padding(5.dp)
    ) {
        Text(
            stringResource(
                R.string.country,
                info.countryName ?: stringResource(R.string.no_information)
            ), color = RaisinBlack
        )
        Text(
            stringResource(
                R.string.coordination,
                info.latitude ?: stringResource(R.string.no_information),
                info.longitude ?: stringResource(R.string.no_information)
            ), color = RaisinBlack,
            modifier = Modifier.clickable {
                val latitude = info.latitude
                val longitude = info.longitude
                if (latitude != null && longitude != null) {
                    val geoUri = Uri.parse("geo:$latitude,$longitude")
                    val intent = Intent(Intent.ACTION_VIEW, geoUri)
                    context.startActivity(intent)
                }
            }
        )
        Text(
            stringResource(
                R.string.type_card,
                info.scheme ?: stringResource(R.string.no_information)
            ), color = RaisinBlack
        )
        Text(
            stringResource(
                R.string.bank,
                info.bankName ?: stringResource(R.string.no_information)
            ), color = RaisinBlack
        )
        Text(
            stringResource(
                R.string.bank_website,
                info.bankUrl ?: stringResource(R.string.no_information)
            ), color = RaisinBlack,
            modifier = Modifier.clickable {
                val url = info.bankUrl
                if (!url.isNullOrEmpty()) {
                    val websiteUri = Uri.parse(url)
                    val intent = Intent(Intent.ACTION_VIEW, websiteUri)
                    context.startActivity(intent)
                }
            }
        )
        Text(
            stringResource(
                R.string.phone_bank,
                info.bankPhone ?: stringResource(R.string.no_information)
            ), color = RaisinBlack,
            modifier = Modifier.clickable {
                info.bankPhone?.let { phone ->
                    val intent = Intent(Intent.ACTION_DIAL).apply {
                        data = Uri.parse("tel:$phone")
                    }
                    context.startActivity(intent)
                }
            }
        )
        Text(
            stringResource(
                R.string.city_bank,
                info.bankCity ?: stringResource(R.string.no_information)
            ), color = RaisinBlack
        )
    }
}


