package com.uti.bwz.presentation.barangs.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp

@Composable
fun TextKategori(
    barangKategori: String
) {
    Row() {
        Icon(imageVector = Icons.Default.Bookmark,
            contentDescription = "Label",
            tint = Color.White
        )
        Text(
            text = barangKategori,
            color = Color.White,
            fontSize = 12.sp
        )
    }

}