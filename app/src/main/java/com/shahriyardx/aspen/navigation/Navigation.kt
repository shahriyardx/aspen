package com.shahriyardx.aspen.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.AirplaneTicket
import androidx.compose.material.icons.automirrored.outlined.AirplaneTicket
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.shahriyardx.aspen.LocalNavController
import com.shahriyardx.aspen.LocalPreferenceHelper
import com.shahriyardx.aspen.components.BottomNavigationBar
import com.shahriyardx.aspen.components.SamplePage
import com.shahriyardx.aspen.screens.SplashScreen
import com.shahriyardx.aspen.screens.home.HomeScreen


data class NavItem(
    val route: String,
    val icon: ImageVector,
    val selectedIcon: ImageVector? = null,
    val hasBadge: Boolean = false,
    val badgeCount: Int = 0,
)

val defaultNavItems = listOf<NavItem>(
    NavItem(route = "home", icon = Icons.Outlined.Home, selectedIcon = Icons.Filled.Home),
    NavItem(
        route = "tickets",
        icon = Icons.AutoMirrored.Outlined.AirplaneTicket,
        selectedIcon = Icons.AutoMirrored.Filled.AirplaneTicket
    ),
    NavItem(
        route = "favourites",
        icon = Icons.Default.FavoriteBorder,
        selectedIcon = Icons.Default.Favorite
    ),
    NavItem(
        route = "settings",
        icon = Icons.Outlined.Settings,
        selectedIcon = Icons.Filled.Settings
    ),
)

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val preferenceHelper = LocalPreferenceHelper.current
    val isFirstVisit = preferenceHelper.getString("isFirstVisit", "true") == "true"

    CompositionLocalProvider(LocalNavController provides navController) {
        NavHost(
            navController = navController,
            startDestination = if (isFirstVisit) "splash" else "home"
        ) {
            composable("splash") {
                SplashScreen()
            }

            composable("home") {
                HomeScreen()
            }

            composable("tickets") {
                Scaffold(bottomBar = {
                    BottomNavigationBar()
                }) { innerPadding ->
                    SamplePage("Tickets")
                }
            }

            composable("favourites") {
                Scaffold(bottomBar = {
                    BottomNavigationBar()
                }) { innerPadding ->
                    SamplePage("Favourites")
                }
            }

            composable("settings") {
                Scaffold(bottomBar = {
                    BottomNavigationBar()
                }) { innerPadding ->
                    SamplePage("Settings")
                }
            }
        }
    }
}