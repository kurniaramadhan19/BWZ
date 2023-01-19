package com.uti.bwz.presentation.barangs.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import com.uti.bwz.core.Constants.Companion.DELETE_BARANG

@Composable
fun DeleteIcon(
    deleteBarang: () -> Unit
) {
    IconButton(
        onClick = deleteBarang
    ) {
        Icon(
            imageVector = Icons.Default.Delete,
            contentDescription = DELETE_BARANG,
        )
    }
}