package com.uti.bwz.presentation.penjualans

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.uti.bwz.ui.theme.bg
import com.uti.bwz.presentation.penjualans.components.AddPenjualanAlertDialog
import com.uti.bwz.presentation.penjualans.components.AddPenjualanFloatingActionButton
import com.uti.bwz.presentation.penjualans.components.PenjualansContent

@Composable
@ExperimentalMaterialApi
fun PenjualansScreen(
    viewModel: PenjualansViewModel = hiltViewModel(),
    navigateToUpdatePenjualanScreen: (penjualanId: Int) -> Unit
) {
    val penjualans by viewModel.penjualans.collectAsState(
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
                }
                Column(

                    modifier = Modifier
                        .fillMaxWidth()
                        .absolutePadding(left = 10.dp, top = 50.dp, bottom = 25.dp)) {
                    Row() {

                        Text(text = "Penjualan", fontSize = 25.sp,style = TextStyle(textDecoration = TextDecoration.Underline), fontWeight = FontWeight.Bold )

                    }

                }
                }


        },
        content = { padding ->
            PenjualansContent(
                padding = padding,
                penjualans = penjualans,
                deletePenjualan = { penjualan ->
                    viewModel.deletePenjualan(penjualan)
                },
                navigateToUpdatePenjualanScreen = navigateToUpdatePenjualanScreen,

            )
            AddPenjualanAlertDialog(
                openDialog = viewModel.openDialog,
                closeDialog = {
                    viewModel.closeDialog()
                },
                addPenjualan = { penjualan ->
                    viewModel.addPenjualan(penjualan)
                }
            )

        },
        floatingActionButton = {
            AddPenjualanFloatingActionButton(
                openDialog = {
                    viewModel.openDialog()
                }
            )

        }


    )
}