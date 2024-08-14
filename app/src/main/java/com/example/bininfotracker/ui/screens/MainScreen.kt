package com.example.bininfotracker.ui.screens

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.bininfotracker.ui.CardInfoViewModel
import com.example.bininfotracker.ui.navigation.BottomNavigation
import com.example.bininfotracker.ui.navigation.NavGraph

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(cardInfoViewModel: CardInfoViewModel) {
    val navController = rememberNavController()
    Scaffold(bottomBar = {
        BottomNavigation(navController = navController)
    }) {
        NavGraph(navHostController = navController, cardInfoViewModel = cardInfoViewModel)
    }

}