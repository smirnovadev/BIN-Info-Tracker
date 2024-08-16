package com.example.bininfotracker.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bininfotracker.ui.HistoryViewModel
import com.example.bininfotracker.ui.SearchViewModel
import com.example.bininfotracker.ui.screens.CardInfoScreen
import com.example.bininfotracker.ui.screens.HistoryScreen

@Composable
fun NavGraph(
    navHostController: NavHostController,
    searchViewModel: SearchViewModel,
    historyViewModel: HistoryViewModel,
    innerPadding: PaddingValues
) {
    NavHost(navController = navHostController, startDestination = BottomItem.SCREEN_SEARCH) {
        composable(BottomItem.SCREEN_SEARCH) {
            CardInfoScreen(viewModel = searchViewModel)
        }
        composable(BottomItem.SCREEN_HISTORY) {
            HistoryScreen(viewModel = historyViewModel, paddingValues = innerPadding)
        }
    }
}