package com.uti.bwz.presentation.penjualans.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.uti.bwz.ui.theme.bg_data
import com.uti.bwz.domain.model.Penjualan

@Composable
@ExperimentalMaterialApi
fun PenjualanCard(
    penjualan: Penjualan,
    deletePenjualan: () -> Unit,
    navigateToUpdatePenjualanScreen: (penjualanId: Int) -> Unit
) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(
                start = 8.dp,
                end = 8.dp,
                top = 4.dp,
                bottom = 4.dp
            )
            .fillMaxWidth(),
        backgroundColor = bg_data,
        elevation = 5.dp,
        onClick = {
            navigateToUpdatePenjualanScreen(penjualan.id)
        }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column {
                TextNamePenjualan(
                    penjualanName = penjualan.name
                )
                TextJumlahbeliPenjualan(
                    penjualanJumlahbeli = penjualan.jumlahbeli,
                    penjualanSatuan = penjualan.satuan
                )
                TextTanggalPenjualan(
                    penjualanTanggal = penjualan.tanggal
                )

            }
            Spacer(
                modifier = Modifier.weight(1f)
            )
            DeleteIconPenjualan(
                deletePenjualan = deletePenjualan
            )
        }

    }

}