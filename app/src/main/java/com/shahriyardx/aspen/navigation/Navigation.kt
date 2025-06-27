package com.shahriyardx.aspen.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.shahriyardx.aspen.screens.HomeScreen
import com.shahriyardx.aspen.screens.SplashScreen


@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Splash) {
        composable<Splash>() {
            SplashScreen()
        }

        composable<Home>() {
            HomeScreen()
        }
    }
}