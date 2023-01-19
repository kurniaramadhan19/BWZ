package com.uti.bwz.data.network

import androidx.room.Database
import androidx.room.RoomDatabase
import com.uti.bwz.domain.model.Barang
import com.uti.bwz.domain.model.Penjualan

@Database(entities = [Barang::class, Penjualan::class], version = 1)
abstract class BarangDb : RoomDatabase() {
    abstract fun barangDao(): BarangDao
    abstract fun penjualanDao(): PenjualanDao
}