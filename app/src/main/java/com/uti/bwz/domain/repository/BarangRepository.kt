package com.uti.bwz.domain.repository

import kotlinx.coroutines.flow.Flow
import com.uti.bwz.domain.model.Barang

typealias Barangs = List<Barang>

interface BarangRepository {
    fun getBarangsFromRoom(): Flow<Barangs>

    fun getBarangFromRoom(id: Int): Barang

    fun addBarangToRoom(barang: Barang)

    fun updateBarangInRoom(barang: Barang)

    fun deleteBarangFromRoom(barang: Barang)

    fun searchBarangFromRoom(name: String): Barang
}