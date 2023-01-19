package com.uti.bwz.presentation.barangs.components

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import com.uti.bwz.core.Constants.Companion.BARANGS_SCREEN

@Composable
fun BarangsTopBar() {
    TopAppBar (
        title = {
            Text(
                text = BARANGS_SCREEN
            )
        }
    )
}