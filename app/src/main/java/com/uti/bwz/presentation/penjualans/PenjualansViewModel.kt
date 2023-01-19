package com.uti.bwz.presentation.penjualans

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.uti.bwz.core.Constants.Companion.NO_VALUE
import com.uti.bwz.domain.model.Penjualan
import com.uti.bwz.domain.repository.PenjualanRepository
import javax.inject.Inject

@HiltViewModel
class PenjualansViewModel @Inject constructor(
    private val repo: PenjualanRepository
) : ViewModel() {
    var penjualan by mutableStateOf(Penjualan(0, NO_VALUE, 0, NO_VALUE, NO_VALUE))
        private set
    var openDialog by mutableStateOf(false)

    var datePickerShown by mutableStateOf(false)

    val penjualans = repo.getPenjualansFromRoom()

    fun getPenjualan(id: Int) = viewModelScope.launch(Dispatchers.IO) {
        penjualan = repo.getPenjualanFromRoom(id)
    }

    fun addPenjualan(penjualan: Penjualan) = viewModelScope.launch(Dispatchers.IO) {
        repo.addPenjualanToRoom(penjualan)
    }

    fun updatePenjualan(penjualan: Penjualan) = viewModelScope.launch(Dispatchers.IO) {
        repo.updatePenjualanInRoom(penjualan)
    }

    fun deletePenjualan(penjualan: Penjualan) = viewModelScope.launch(Dispatchers.IO) {
        repo.deletePenjualanFromRoom(penjualan)
    }

    fun updateName(name: String) {
        penjualan = penjualan.copy(
            name = name
        )
    }

    fun updateJumlahbeli(jumlahbeli: Int) {
        penjualan = penjualan.copy(
            jumlahbeli = jumlahbeli
        )
    }

    fun updateSatuan(satuan: String) {
        penjualan = penjualan.copy(
            satuan = satuan
        )
    }

    fun updateTanggal(tanggal: String) {
        penjualan = penjualan.copy(
            tanggal = tanggal
        )
    }




    fun openDialog() {
        openDialog = true
    }

    fun closeDialog() {
        openDialog = false
    }
}