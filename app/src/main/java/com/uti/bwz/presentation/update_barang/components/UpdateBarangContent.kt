package com.uti.bwz.presentation.update_barang.components

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
import com.uti.bwz.domain.model.Barang

@Composable
fun UpdateBarangContent(
    padding: PaddingValues,
    barang: Barang,
    updateName: (name: String) -> Unit,
    updateKategori: (kategori: String) -> Unit,
    updateModal: (modal: Int) -> Unit,
    updateHarga: (harga: Int) -> Unit,
    updateSatuan: (satuan: String) -> Unit,
    updateBarang: (barang: Barang) -> Unit,
    navigateBack: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth().background(bg),
    ) {
        Row() {
            Text(
                text = "Ubah Barang",
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
                    value = barang.name,
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
                Text(text = "Kategori", modifier = Modifier.absolutePadding(right = 103.dp))
                BasicTextField(
                    value = barang.kategori,
                    singleLine = true,
                    onValueChange = { kategori ->
                        updateKategori(kategori)
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
                Text(text = "Modal", modifier = Modifier.absolutePadding(right = 117.dp))
                BasicTextField(
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    value = barang.modal.toString(),
                    singleLine = true,
                    onValueChange = { modal ->
                        updateModal(modal.toInt())
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
                Text(text = "Harga", modifier = Modifier.absolutePadding(right = 118.dp))
                BasicTextField(
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    value = barang.harga.toString(),
                    singleLine = true,
                    onValueChange = { harga ->
                        updateHarga(harga.toInt())
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
                Text(text = "Satuan", modifier = Modifier.absolutePadding(right = 112.dp))
                BasicTextField(
                    value = barang.satuan,
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
                modifier = Modifier.height(26.dp)
            )
            Button(
                onClick = {
                    updateBarang(barang)
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