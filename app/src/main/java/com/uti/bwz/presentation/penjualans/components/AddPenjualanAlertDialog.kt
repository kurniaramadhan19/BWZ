package com.uti.bwz.presentation.penjualans.components

import android.app.DatePickerDialog
import android.os.Build
import android.widget.DatePicker
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.job
import com.uti.bwz.core.Constants.Companion.ADD
import com.uti.bwz.core.Constants.Companion.DISMISS
import com.uti.bwz.core.Constants.Companion.NO_VALUE
import com.uti.bwz.domain.model.Penjualan
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AddPenjualanAlertDialog(
    openDialog: Boolean,
    closeDialog: () -> Unit,
    addPenjualan: (penjualan : Penjualan) -> Unit
) {
    if (openDialog) {
        var name by remember { mutableStateOf(NO_VALUE) }
        var jumlahbeli by remember { mutableStateOf(0) }
        var satuan by remember {mutableStateOf(NO_VALUE) }
        var tanggal by remember {mutableStateOf(NO_VALUE) }
        val context = LocalContext.current
        val focusManager = LocalFocusManager.current

        val date = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            LocalDate.now()
        } else {
            return
        }

        val year = date.year
        val monthValue = date.monthValue
        val dayOfMonth = date.dayOfMonth

        val datePickerDialog = remember {
            DatePickerDialog(
                context, { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
                    tanggal = "$dayOfMonth/${monthValue+1}/$year"
                    focusManager.clearFocus()
                }, year, monthValue, dayOfMonth
            ).apply {
                setOnDismissListener {
                    focusManager.clearFocus()
                }
            }
        }
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
                        Text(text = "Jumlah Beli", modifier = Modifier.absolutePadding(right = 76.dp))
                        BasicTextField(
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            value = jumlahbeli.toString(),
                            singleLine = true,
                            onValueChange = { value -> jumlahbeli = value.toIntOrNull() ?: 0 },
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
                        Text(text = "Tanggal", modifier = Modifier.absolutePadding(right = 90.dp))
                        Box(modifier = Modifier
                            .size(width = 150.dp, height = 60.dp)
                            .absolutePadding(top = 10.dp, bottom = 10.dp, left = 10.dp)
                            .background(Color.LightGray),
                            contentAlignment = Alignment.Center,
                        ){
                            TextButton(
                                onClick = {
                                    datePickerDialog.show()
                                }
                            ) {
                                Text(
                                    text = "${tanggal}",
                                    fontSize = 13.sp,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                    }
                    LaunchedEffect(Unit) {
                        coroutineContext.job.invokeOnCompletion {
                            focusRequester.requestFocus()
                        }
                    }
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
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
                        val penjualan = Penjualan(0, name, jumlahbeli, satuan, tanggal)
                        addPenjualan(penjualan)
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
