package com.example.bininfotracker

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.example.bininfotracker.ui.HistoryViewModel
import com.example.bininfotracker.ui.SearchViewModel
import com.example.bininfotracker.ui.screens.MainScreen
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val searchViewModel: SearchViewModel by viewModel()
    private val historyViewModel: HistoryViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen(searchViewModel = searchViewModel, historyViewModel = historyViewModel)
        }
    }
}
