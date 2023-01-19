package com.uti.bwz.presentation.barangs.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.uti.bwz.domain.model.Barang
import com.uti.bwz.domain.repository.Barangs

@Composable
@ExperimentalMaterialApi
fun BarangsContent(
    padding: PaddingValues,
    barangs: Barangs,
    deleteBarang: (barang: Barang) -> Unit,
    navigateToUpdateBarangScreen: (barangId: Int) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(padding)
    ) {
        items(
            items = barangs
        ) { barang ->
            BarangCard(
                barang = barang,
                deleteBarang = {
                    deleteBarang(barang)
                },
                navigateToUpdateBarangScreen = navigateToUpdateBarangScreen
            )

        }

    }
}