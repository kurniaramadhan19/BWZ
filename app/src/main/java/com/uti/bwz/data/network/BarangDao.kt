package com.uti.bwz.data.network

import androidx.room.*
import androidx.room.OnConflictStrategy.Companion.IGNORE
import kotlinx.coroutines.flow.Flow
import com.uti.bwz.core.Constants.Companion.BARANG_TABLE
import com.uti.bwz.domain.model.Barang
import com.uti.bwz.domain.repository.Barangs

@Dao
interface BarangDao {
    @Query("SELECT * FROM $BARANG_TABLE ORDER BY id ASC")
    fun getBarangs(): Flow<Barangs>

    @Query("SELECT * FROM $BARANG_TABLE WHERE id = :id")
    fun getBarang(id: Int): Barang

    @Insert(onConflict = IGNORE)
    fun addBarang(barang: Barang)

    @Update
    fun updateBarang(barang: Barang)

    @Delete
    fun deleteBarang(barang: Barang)

    @Query("SELECT * FROM $BARANG_TABLE WHERE name LIKE :name")
    fun searchBarang(name: String): Barang
}