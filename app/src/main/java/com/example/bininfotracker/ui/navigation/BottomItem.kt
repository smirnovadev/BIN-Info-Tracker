package com.example.bininfotracker.ui.navigation

import com.example.bininfotracker.R

sealed class BottomItem(
    val title: String,
    val iconId: Int,
    val route: String
) {
    data object CardInfoScreen: BottomItem("Search", R.drawable.ic_search, SCREEN_SEARCH)
    data object RequestHistoryScreen: BottomItem("History", R.drawable.ic_history, SCREEN_HISTORY)
    companion object Routes {
        const val SCREEN_SEARCH = "screen_search"
        const val SCREEN_HISTORY = "screen_history"
    }
}