package com.uti.bwz.presentation.update_penjualan.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uti.bwz.ui.theme.bg
import com.uti.bwz.core.Constants.Companion.UPDATE
import com.uti.bwz.domain.model.Penjualan

@Composable
fun UpdatePenjualanContent(
    padding: PaddingValues,
    penjualan: Penjualan,
    updateName: (name: String) -> Unit,
    updateJumlahbeli: (jumlahbeli: Int) -> Unit,
    updateTanggal: (tanggal: String) -> Unit,
    updateSatuan: (satuan: String) -> Unit,
    updatePenjualan: (penjualan: Penjualan) -> Unit,
    navigateBack: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth().background(bg),
    ) {
        Row() {
            Text(
                text = "Ubah Penjualan",
                fontSize = 25.sp,
                style = TextStyle(textDecoration = TextDecoration.Underline),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.absolutePadding(top = 70.dp, bottom = 70.dp)
            )
        }



        Column(
            modifier = Modifier.fillMaxSize().padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Row(modifier = Modifier
                .fillMaxWidth().absolutePadding(right = 60.dp, left = 60.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Nama Barang", modifier = Modifier.absolutePadding(right = 70.dp))
                BasicTextField(
                    value = penjualan.name,
                    singleLine = true,
                    onValueChange = { name ->
                        updateName(name)
                    },
                    modifier = Modifier
                        .background(Color.LightGray)
                        .padding(10.dp)
                )
            }

            Spacer(
                modifier = Modifier.height(16.dp)
            )
            Row(modifier = Modifier
                .fillMaxWidth().absolutePadding(right = 60.dp, left = 60.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Jumlah Beli", modifier = Modifier.absolutePadding(right = 70.dp))
                BasicTextField(
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    value = penjualan.jumlahbeli.toString(),
                    singleLine = true,
                    onValueChange = { jumlahbeli ->
                        updateJumlahbeli(jumlahbeli.toInt())
                    },
                    modifier = Modifier
                        .background(Color.LightGray)
                        .padding(10.dp)
                )
            }
            Spacer(
                modifier = Modifier.height(16.dp)
            )

            Row(modifier = Modifier
                .fillMaxWidth().absolutePadding(right = 60.dp, left = 60.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Satuan", modifier = Modifier.absolutePadding(right = 108.dp))
                BasicTextField(
                    value = penjualan.satuan,
                    singleLine = true,
                    onValueChange = { satuan ->
                        updateSatuan(satuan)
                    },
                    modifier = Modifier
                        .background(Color.LightGray)
                        .padding(10.dp)
                )
            }
            Spacer(
                modifier = Modifier.height(16.dp)
            )
            Row(modifier = Modifier
                .fillMaxWidth().absolutePadding(right = 60.dp, left = 60.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Tanggal", modifier = Modifier.absolutePadding(right = 105.dp))
                BasicTextField(
                    value = penjualan.tanggal,
                    singleLine = true,
                    onValueChange = { tanggal ->
                        updateTanggal(tanggal)
                    },
                    modifier = Modifier
                        .background(Color.LightGray)
                        .padding(10.dp)
                )
            }

            Spacer(
                modifier = Modifier.height(26.dp)
            )
            Button(
                onClick = {
                    updatePenjualan(penjualan)
                    navigateBack()
                }
            ) {
                Text(
                    text = UPDATE
                )
            }

        }
    }
}