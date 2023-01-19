package com.uti.bwz.presentation.update_penjualan

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.uti.bwz.presentation.penjualans.PenjualansViewModel
import com.uti.bwz.presentation.update_penjualan.components.UpdatePenjualanContent

@Composable
fun UpdatePenjualanScreen(
    viewModel: PenjualansViewModel = hiltViewModel(),
    penjualanId: Int,
    navigateBack: () -> Unit
) {
    LaunchedEffect(Unit) {
        viewModel.getPenjualan(penjualanId)
    }
    Scaffold(
        content = { padding ->
            UpdatePenjualanContent(
                padding = padding,
                penjualan = viewModel.penjualan,
                updateName = { name ->
                    viewModel.updateName(name)
                },
                updateJumlahbeli = { jumlahbeli ->
                    viewModel.updateJumlahbeli(jumlahbeli)
                },
                updateSatuan = { satuan ->
                    viewModel.updateSatuan(satuan)
                },
                updateTanggal = { tanggal ->
                    viewModel.updateTanggal(tanggal)
                },
                updatePenjualan = { penjualan ->
                    viewModel.updatePenjualan(penjualan)
                },
                navigateBack = navigateBack
            )
        }
    )
}