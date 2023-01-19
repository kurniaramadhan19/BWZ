package com.uti.bwz

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.uti.bwz.core.Constants
import com.uti.bwz.presentation.barangs.BarangsScreen
import com.uti.bwz.presentation.penjualans.PenjualansScreen
import com.uti.bwz.presentation.penjualans.components.KeuntunganScreen
import com.uti.bwz.presentation.update_barang.UpdateBarangScreen
import com.uti.bwz.presentation.update_penjualan.UpdatePenjualanScreen


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.BarangScreen.route
    ) {
        composable(
            route = BottomBarScreen.BarangScreen.route
        ) {
            BarangsScreen(
                navigateToUpdateBarangScreen = { barangId ->
                    navController.navigate("${Screen.UpdateBarangScreen.route}/${barangId}")
                }
            )
        }
        composable(route = BottomBarScreen.PenjualanScreen.route) {
            PenjualansScreen(
                navigateToUpdatePenjualanScreen = { penjualanId ->
                    navController.navigate("${Screen.UpdatePenjualanScreen.route}/${penjualanId}")
                }
            )
        }
        composable(route = BottomBarScreen.KeuntunganScreen.route) {
            KeuntunganScreen()
        }

        composable(
            route = "${Screen.UpdateBarangScreen.route}/{${Constants.BARANG_ID}}",
            arguments = listOf(
                navArgument(Constants.BARANG_ID) {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val barangId = backStackEntry.arguments?.getInt(Constants.BARANG_ID) ?: 0
            UpdateBarangScreen(
                barangId = barangId,
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = "${Screen.UpdatePenjualanScreen.route}/{${Constants.PENJUALAN_ID}}",
            arguments = listOf(
                navArgument(Constants.PENJUALAN_ID) {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val penjualanId = backStackEntry.arguments?.getInt(Constants.PENJUALAN_ID) ?: 0
            UpdatePenjualanScreen(
                penjualanId = penjualanId,
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }
}}