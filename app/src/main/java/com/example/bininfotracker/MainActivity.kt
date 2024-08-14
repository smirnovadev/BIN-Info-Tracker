package com.example.bininfotracker

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.example.bininfotracker.ui.CardInfoViewModel
import com.example.bininfotracker.ui.screens.CardInfoScreen
import com.example.bininfotracker.ui.screens.MainScreen
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: CardInfoViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CardInfoScreen(viewModel)
            MainScreen(cardInfoViewModel = viewModel)
        }
    }
}
