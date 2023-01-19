package com.uti.bwz.presentation.penjualans.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.uti.bwz.domain.model.Barang
import com.uti.bwz.domain.model.Penjualan
import com.uti.bwz.domain.repository.Barangs
import com.uti.bwz.domain.repository.Penjualans

@Composable
@ExperimentalMaterialApi
fun PenjualansContent(
    padding: PaddingValues,
    penjualans: Penjualans,
    deletePenjualan: (penjualan : Penjualan) -> Unit,
    navigateToUpdatePenjualanScreen: (penjualanId: Int) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(padding)
    ) {
        items(
            items = penjualans
        ) { penjualan ->
            PenjualanCard(
                penjualan = penjualan,
                deletePenjualan = {
                    deletePenjualan(penjualan)
                },
                navigateToUpdatePenjualanScreen = navigateToUpdatePenjualanScreen
            )

        }

    }
}