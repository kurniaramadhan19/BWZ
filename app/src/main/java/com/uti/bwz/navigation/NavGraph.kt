package com.uti.bwz

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.uti.bwz.BottomBarScreen
import com.uti.bwz.Screen
import com.uti.bwz.navigation.MainScreen
import com.uti.bwz.splashsceen.AnimatedSplashScreen

@ExperimentalMaterialApi
@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route) {
            AnimatedSplashScreen(navController = navController)
        }
        composable(route = BottomBarScreen.BarangScreen.route) {
            MainScreen()
        }
    }
}