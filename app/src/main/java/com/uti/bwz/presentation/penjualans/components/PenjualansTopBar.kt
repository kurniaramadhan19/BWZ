package com.uti.bwz.presentation.penjualans.components

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import com.uti.bwz.core.Constants.Companion.PENJUALANS_SCREEN

@Composable
fun PenjualansTopBar() {
    TopAppBar (
        title = {
            Text(
                text = PENJUALANS_SCREEN
            )
        }
    )
}