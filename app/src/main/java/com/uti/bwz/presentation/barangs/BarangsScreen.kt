package com.uti.bwz.presentation.barangs

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.uti.bwz.R
import com.uti.bwz.core.Constants
import com.uti.bwz.presentation.barangs.components.AddBarangAlertDialog
import com.uti.bwz.presentation.barangs.components.AddBarangFloatingActionButton
import com.uti.bwz.presentation.barangs.components.BarangsContent
import com.uti.bwz.ui.theme.bg
import kotlinx.coroutines.job

@Composable
@ExperimentalMaterialApi
fun BarangsScreen(
    viewModel: BarangsViewModel = hiltViewModel(),
    navigateToUpdateBarangScreen: (barangId: Int) -> Unit,

) {
    var name by remember { mutableStateOf(Constants.NO_VALUE) }
    val barangs by viewModel.barangs.collectAsState(
        initial = emptyList()
    )

    Scaffold(
        backgroundColor = bg,
        topBar = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()) {
                Row() {
                    Image(painter = painterResource(id = R.drawable.wz2), contentDescription = "logo",
                        modifier = Modifier
                            .size(150.dp).absolutePadding(top=30.dp, bottom = 20.dp)
                    )
                }
                Column(

                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)) {
                    Row() {

                        Text(text = "Daftar Barang", fontSize = 25.sp,style = TextStyle(textDecoration = TextDecoration.Underline), fontWeight = FontWeight.Bold )

                    }
                    Row() {
                        Box(modifier = Modifier
                            .absolutePadding(top = 10.dp)
                            .border(
                                width = 1.dp,
                                color = Color.LightGray,
                                shape = RoundedCornerShape(20.dp)
                            )
                            .size(width = 200.dp, height = 30.dp),
                            contentAlignment = Alignment.CenterStart
                        )
                        {
                                Icon(
                                    imageVector = Icons.Default.Search,
                                    contentDescription = Constants.SEARCH_BARANG,
                                    modifier = Modifier.absolutePadding(left = 5.dp)
                                )

                            BasicTextField(
                                value = name,
                                singleLine = true,
                                onValueChange = { name = it },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(Color.Transparent)
                                    .absolutePadding(left = 40.dp, right = 10.dp)
                            )
                            LaunchedEffect(Unit) {
                                coroutineContext.job.invokeOnCompletion {
                                }
                            }
                        }
                    }
                }
                }


        },
        content = { padding ->
            BarangsContent(
                padding = padding,
                barangs = barangs,
                deleteBarang = { barang ->
                    viewModel.deleteBarang(barang)
                },
                navigateToUpdateBarangScreen = navigateToUpdateBarangScreen,

            )
            AddBarangAlertDialog(
                openDialog = viewModel.openDialog,
                closeDialog = {
                    viewModel.closeDialog()
                },
                addBarang = { barang ->
                    viewModel.addBarang(barang)
                }
            )

        },
        floatingActionButton = {
            AddBarangFloatingActionButton(
                openDialog = {
                    viewModel.openDialog()
                }
            )

        }


    )
}