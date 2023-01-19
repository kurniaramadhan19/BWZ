package com.uti.bwz.presentation.penjualans.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun TextNamePenjualan(
    penjualanName: String
) {
    Text(
        text = penjualanName,
        color = Color.White,
        fontSize = 25.sp
    )
}