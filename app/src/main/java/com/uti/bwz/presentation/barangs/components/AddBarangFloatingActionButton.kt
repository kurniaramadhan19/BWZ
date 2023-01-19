package com.uti.bwz.presentation.barangs.components

import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.size
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.uti.bwz.core.Constants.Companion.ADD_BARANG

@Composable
fun AddBarangFloatingActionButton(
    openDialog: () -> Unit
) {
    FloatingActionButton(
        onClick = openDialog,
        backgroundColor = Color.Black,
        modifier = Modifier.absolutePadding(bottom = 70.dp, right = 5.dp)
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = ADD_BARANG,
            tint = Color.White,
            modifier = Modifier.size(40.dp)
        )

    }

}