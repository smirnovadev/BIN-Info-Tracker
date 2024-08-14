package com.example.bininfotracker.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.bininfotracker.ui.theme.CoolGray
import com.example.bininfotracker.ui.theme.Platinum
import com.example.bininfotracker.ui.theme.RaisinBlack

@Composable
fun BottomNavigation(
    navController: NavController
) {
    val listItems = listOf(
        BottomItem.CardInfoScreen,
        BottomItem.RequestHistoryScreen

    )
    NavigationBar(
        Modifier.background(Platinum)
    ) {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route
        listItems.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route)
                },
                icon = {
                    Icon(painter = painterResource(id = item.iconId), contentDescription = "")
                },
                label = {
                    Text(
                        text = item.title, fontSize = 10.sp
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedTextColor = RaisinBlack,
                    unselectedTextColor = CoolGray
                )
            )
        }
    }
}