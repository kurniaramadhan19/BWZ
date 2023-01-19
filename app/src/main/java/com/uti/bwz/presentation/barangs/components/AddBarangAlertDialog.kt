package com.uti.bwz.presentation.barangs.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.job
import com.uti.bwz.core.Constants.Companion.ADD
import com.uti.bwz.core.Constants.Companion.DISMISS
import com.uti.bwz.core.Constants.Companion.NO_VALUE
import com.uti.bwz.domain.model.Barang
import kotlin.math.absoluteValue

@Composable
fun AddBarangAlertDialog(
    openDialog: Boolean,
    closeDialog: () -> Unit,
    addBarang: (barang: Barang) -> Unit
) {
    if (openDialog) {
        var name by remember { mutableStateOf(NO_VALUE) }
        var kategori by remember { mutableStateOf(NO_VALUE) }
        var modal by remember {mutableStateOf(0) }
        var harga by remember {mutableStateOf(0) }
        var satuan by remember {mutableStateOf(NO_VALUE) }
        val focusRequester = FocusRequester()

        AlertDialog(
            onDismissRequest = closeDialog,
            text = {
                Column{
                    Row(modifier = Modifier
                        .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(text = "Nama Barang", modifier = Modifier.absolutePadding(right = 66.dp))
                    BasicTextField(
                        value = name,
                        singleLine = true,
                        onValueChange = { name = it },
                        modifier = Modifier
                            .focusRequester(focusRequester)
                            .background(Color.LightGray)
                            .padding(10.dp)
                    )
                    LaunchedEffect(Unit) {
                        coroutineContext.job.invokeOnCompletion {
                            focusRequester.requestFocus()
                        }
                    }}
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )

                    Row(modifier = Modifier
                        .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Kategori", modifier = Modifier.absolutePadding(right = 99.dp))
                        BasicTextField(
                            value = kategori,
                            singleLine = true,
                            onValueChange = { kategori = it },
                            modifier = Modifier
                                .background(Color.LightGray)
                                .padding(10.dp)
                        )
                    }
                    LaunchedEffect(Unit) {
                        coroutineContext.job.invokeOnCompletion {
                            focusRequester.requestFocus()
                        }
                    }
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )

                    Row(modifier = Modifier
                        .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Modal", modifier = Modifier.absolutePadding(right = 113.dp))
                        BasicTextField(
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            value = modal.toString(),
                            singleLine = true,
                            onValueChange = { value -> modal = value.toIntOrNull() ?: 0 },
                            modifier = Modifier
                                .background(Color.LightGray)
                                .padding(10.dp)
                        )
                    }
                    LaunchedEffect(Unit) {
                        coroutineContext.job.invokeOnCompletion {
                            focusRequester.requestFocus()
                        }
                    }
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )

                    Row(modifier = Modifier
                        .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Harga", modifier = Modifier.absolutePadding(right = 114.dp))
                        BasicTextField(
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            value = harga.toString(),
                            singleLine = true,
                            onValueChange = { value -> harga = value.toIntOrNull() ?: 0 },
                            modifier = Modifier
                                .background(Color.LightGray)
                                .padding(10.dp)
                        )
                    }
                    LaunchedEffect(Unit) {
                        coroutineContext.job.invokeOnCompletion {
                            focusRequester.requestFocus()
                        }
                    }
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )

                    Row(modifier = Modifier
                        .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Satuan", modifier = Modifier.absolutePadding(right = 108.dp))
                        BasicTextField(
                            value = satuan,
                            singleLine = true,
                            onValueChange = { satuan = it },
                            modifier = Modifier
                                .background(Color.LightGray)
                                .padding(10.dp)
                        )
                    }
                }
            },
            confirmButton = {
                Box(modifier = Modifier
                    .size(width = 120.dp, height = 70.dp)
                    .padding(10.dp)
                    .background(Color.Green,shape = RoundedCornerShape(20.dp)),
                    contentAlignment = Alignment.Center,
                ){
                TextButton(
                    onClick = {
                        closeDialog()
                        val barang = Barang(0, name, kategori, modal, harga, satuan)
                        addBarang(barang)
                    }
                ) {
                    Text(
                        text = ADD,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                }
            }},
            dismissButton = {
                Box(modifier = Modifier
                    .size(width = 120.dp, height = 70.dp)
                    .padding(10.dp)
                    .background(Color.Red,shape = RoundedCornerShape(20.dp)),
                    contentAlignment = Alignment.Center,
                    ){
                TextButton(
                    onClick = closeDialog
                ) {
                    Text(
                        text = DISMISS,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                }
            }}

        )
    }
}