package com.example.bininfotracker.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bininfotracker.ui.CardInfoViewModel
import com.example.bininfotracker.ui.screens.CardInfoScreen
import com.example.bininfotracker.ui.screens.RequestHistoryScreen

@Composable
fun NavGraph(
    navHostController: NavHostController,
    cardInfoViewModel: CardInfoViewModel
) {
    NavHost(navController = navHostController, startDestination = BottomItem.SCREEN_SEARCH) {
        composable(BottomItem.SCREEN_SEARCH) {
            CardInfoScreen(viewModel = cardInfoViewModel)
        }
        composable(BottomItem.SCREEN_HISTORY) {
            RequestHistoryScreen()
        }
    }
}