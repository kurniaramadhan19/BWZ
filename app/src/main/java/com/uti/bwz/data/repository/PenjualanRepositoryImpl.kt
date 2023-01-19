package com.uti.bwz.data.repository

import com.uti.bwz.data.network.PenjualanDao
import com.uti.bwz.domain.model.Penjualan
import com.uti.bwz.domain.repository.PenjualanRepository

class PenjualanRepositoryImpl(
    private val penjualanDao: PenjualanDao
) : PenjualanRepository {
    override fun getPenjualansFromRoom() = penjualanDao.getPenjualans()

    override fun getPenjualanFromRoom(id: Int) = penjualanDao.getPenjualan(id)

    override fun addPenjualanToRoom(penjualan: Penjualan) = penjualanDao.addPenjualan(penjualan)

    override fun updatePenjualanInRoom(penjualan: Penjualan) = penjualanDao.updatePenjualan(penjualan)

    override fun deletePenjualanFromRoom(penjualan: Penjualan) = penjualanDao.deletePenjualan(penjualan)
}