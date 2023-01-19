package com.uti.bwz.data.network

import androidx.room.*
import androidx.room.OnConflictStrategy.Companion.IGNORE
import kotlinx.coroutines.flow.Flow
import com.uti.bwz.core.Constants.Companion.PENJUALAN_TABLE
import com.uti.bwz.domain.model.Penjualan
import com.uti.bwz.domain.repository.Penjualans

@Dao
interface PenjualanDao {
    @Query("SELECT * FROM $PENJUALAN_TABLE ORDER BY id ASC")
    fun getPenjualans(): Flow<Penjualans>

    @Query("SELECT * FROM $PENJUALAN_TABLE WHERE id = :id")
    fun getPenjualan(id: Int): Penjualan

    @Insert(onConflict = IGNORE)
    fun addPenjualan(penjualan: Penjualan)

    @Update
    fun updatePenjualan(barang: Penjualan)

    @Delete
    fun deletePenjualan(barang: Penjualan)
}