package com.uti.bwz.presentation.penjualans.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import com.uti.bwz.core.Constants.Companion.DELETE_PENJUALAN

@Composable
fun DeleteIconPenjualan(
    deletePenjualan: () -> Unit
) {
    IconButton(
        onClick = deletePenjualan
    ) {
        Icon(
            imageVector = Icons.Default.Delete,
            contentDescription = DELETE_PENJUALAN,
        )
    }
}