package com.uti.bwz.presentation.penjualans.components

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Build
import android.widget.DatePicker
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uti.bwz.ui.theme.bg
import com.uti.bwz.R
import com.uti.bwz.core.Constants
import java.time.LocalDate


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun KeuntunganScreen() {
    var tanggal by remember { mutableStateOf(Constants.NO_VALUE) }
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
    Scaffold(
        backgroundColor = bg,
        topBar = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()) {
                Column(

                    modifier = Modifier
                        .fillMaxWidth()
                        .absolutePadding(left = 10.dp, top = 50.dp, bottom = 25.dp)) {
                    Row() {

                        Text(text = "Keuntungan", fontSize = 25.sp,style = TextStyle(textDecoration = TextDecoration.Underline), fontWeight = FontWeight.Bold )

                    }
                    Row() {
                        Box(modifier = Modifier
                            .absolutePadding(top = 10.dp)
                            .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(20.dp))
                            .size(width = 200.dp, height = 30.dp),
                            contentAlignment = Alignment.CenterStart
                        )
                        {
                            Icon(Icons.Default.Search, contentDescription = "Cari Barang", modifier = Modifier.absolutePadding(left = 5.dp))
                            Box(modifier = Modifier
                                .size(width = 200.dp, height = 30.dp)
                                .background(Color.Transparent),
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
                                        textAlign = TextAlign.Center,
                                        color = Color.Black
                                    )
                                }
                            }
                        }
                    }
                }
            }


        }
    ){}

}