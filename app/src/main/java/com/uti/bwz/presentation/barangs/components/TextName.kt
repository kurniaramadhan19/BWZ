package com.uti.bwz.presentation.barangs.components

import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextName(
    barangName: String
) {
    Text(
        text = barangName,
        color = Color.White,
        fontSize = 25.sp,
        modifier = Modifier.absolutePadding(left = 5.dp)
    )
}