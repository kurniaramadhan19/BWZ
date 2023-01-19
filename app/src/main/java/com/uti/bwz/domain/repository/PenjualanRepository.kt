package com.uti.bwz.domain.repository

import com.uti.bwz.domain.model.Penjualan
import kotlinx.coroutines.flow.Flow

typealias Penjualans = List<Penjualan>

interface PenjualanRepository {
    fun getPenjualansFromRoom(): Flow<Penjualans>

    fun getPenjualanFromRoom(id: Int): Penjualan

    fun addPenjualanToRoom(penjualan: Penjualan)

    fun updatePenjualanInRoom(penjualan: Penjualan)

    fun deletePenjualanFromRoom(penjualan: Penjualan)
}