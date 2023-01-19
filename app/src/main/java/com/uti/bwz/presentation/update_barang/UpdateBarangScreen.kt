package com.uti.bwz.presentation.update_barang

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.uti.bwz.presentation.barangs.BarangsViewModel
import com.uti.bwz.presentation.update_barang.components.UpdateBarangContent

@Composable
fun UpdateBarangScreen(
    viewModel: BarangsViewModel = hiltViewModel(),
    barangId: Int,
    navigateBack: () -> Unit
) {
    LaunchedEffect(Unit) {
        viewModel.getBarang(barangId)
    }
    Scaffold(
        content = { padding ->
            UpdateBarangContent(
                padding = padding,
                barang = viewModel.barang,
                updateName = { name ->
                    viewModel.updateName(name)
                },
                updateKategori = { kategori ->
                    viewModel.updateKategori(kategori)
                },
                updateModal = { modal ->
                    viewModel.updateModal(modal)
                },
                updateHarga = { harga ->
                    viewModel.updateHarga(harga)
                },
                updateSatuan = { satuan ->
                    viewModel.updateSatuan(satuan)
                },
                updateBarang = { barang ->
                    viewModel.updateBarang(barang)
                },
                navigateBack = navigateBack
            )
        }
    )
}