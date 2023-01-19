package com.uti.bwz.data.repository

import com.uti.bwz.data.network.BarangDao
import com.uti.bwz.domain.model.Barang
import com.uti.bwz.domain.repository.BarangRepository

class BarangRepositoryImpl(
    private val barangDao: BarangDao
) : BarangRepository {
    override fun getBarangsFromRoom() = barangDao.getBarangs()

    override fun getBarangFromRoom(id: Int) = barangDao.getBarang(id)

    override fun addBarangToRoom(barang: Barang) = barangDao.addBarang(barang)

    override fun updateBarangInRoom(barang: Barang) = barangDao.updateBarang(barang)

    override fun deleteBarangFromRoom(barang: Barang) = barangDao.deleteBarang(barang)

    override fun searchBarangFromRoom(name: String) = barangDao.searchBarang(name)
}