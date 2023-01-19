package com.uti.bwz.presentation.barangs

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.uti.bwz.core.Constants.Companion.NO_VALUE
import com.uti.bwz.domain.model.Barang
import com.uti.bwz.domain.repository.BarangRepository
import javax.inject.Inject

@HiltViewModel
class BarangsViewModel @Inject constructor(
    private val repo: BarangRepository
) : ViewModel() {
    var barang by mutableStateOf(Barang(0, NO_VALUE, NO_VALUE, 0, 0, NO_VALUE))
        private set
    var openDialog by mutableStateOf(false)

    val barangs = repo.getBarangsFromRoom()

    fun getBarang(id: Int) = viewModelScope.launch(Dispatchers.IO) {
        barang = repo.getBarangFromRoom(id)
    }

    fun addBarang(barang: Barang) = viewModelScope.launch(Dispatchers.IO) {
        repo.addBarangToRoom(barang)
    }

    fun updateBarang(barang: Barang) = viewModelScope.launch(Dispatchers.IO) {
        repo.updateBarangInRoom(barang)
    }

    fun deleteBarang(barang: Barang) = viewModelScope.launch(Dispatchers.IO) {
        repo.deleteBarangFromRoom(barang)
    }
    fun searchBarang(name: String) = viewModelScope.launch(Dispatchers.IO) {
        barang = repo.searchBarangFromRoom(name)
    }

    fun updateName(name: String) {
        barang = barang.copy(
            name = name
        )
    }

    fun updateKategori(kategori: String) {
        barang = barang.copy(
            kategori = kategori
        )
    }

    fun updateModal(modal: Int) {
        barang = barang.copy(
            modal = modal
        )
    }

    fun updateHarga(harga: Int) {
        barang = barang.copy(
            harga = harga
        )
    }

    fun updateSatuan(satuan: String) {
        barang = barang.copy(
            satuan = satuan
        )
    }

    fun openDialog() {
        openDialog = true
    }

    fun closeDialog() {
        openDialog = false
    }
}