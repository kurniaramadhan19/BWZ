package com.uti.bwz

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalanceWallet
import androidx.compose.material.icons.filled.ListAlt
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.ui.graphics.vector.ImageVector
import com.uti.bwz.core.Constants
import com.uti.bwz.core.Constants.Companion.BARANGS_SCREEN
import com.uti.bwz.core.Constants.Companion.PENJUALANS_SCREEN


sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {

    object PenjualanScreen : BottomBarScreen(
        PENJUALANS_SCREEN,
        title = "Penjualan",
        icon = Icons.Default.ShoppingBag
    )

    object BarangScreen : BottomBarScreen(
        BARANGS_SCREEN,
        title = "Barang",
        icon = Icons.Default.ListAlt
    )

    object KeuntunganScreen : BottomBarScreen(
        route = "keuntungan",
        title = "Keuntungan",
        icon = Icons.Default.AccountBalanceWallet
    )

}
sealed class Screen(val route: String) {
    object UpdateBarangScreen: Screen(Constants.UPDATE_BARANG_SCREEN)
    object UpdatePenjualanScreen: Screen(Constants.UPDATE_PENJUALAN_SCREEN)
    object Splash : Screen("splash_screen")
}