package com.uti.bwz.presentation.penjualans.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun TextJumlahbeliPenjualan(
    penjualanJumlahbeli: Int,
    penjualanSatuan: String
) {
    Row() {
        Text(
            text = "$penjualanJumlahbeli $penjualanSatuan",
            color = Color.White,
            fontSize = 12.sp
        )
    }

}