package com.uti.bwz.presentation.barangs.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.uti.bwz.core.Constants

@Composable
fun TextHarga(
    barangHarga: Int,
    barangSatuan: String
) {
    Row() {
        Icon(
            imageVector = Icons.Default.AttachMoney,
            contentDescription = "Label",
            tint = Color.White
        )
        Text(
            text = "Rp $barangHarga/$barangSatuan",
            color = Color.White,
            fontSize = 12.sp
        )
    }

}