package com.uti.bwz.presentation.barangs.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun TextModal(
    barangModal: Int
) {
    Text(
        text = "Rp $barangModal",
        color = Color.DarkGray,
        fontSize = 12.sp
    )
}