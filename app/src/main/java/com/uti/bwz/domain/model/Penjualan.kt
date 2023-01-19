package com.uti.bwz.domain.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.PrimaryKey
import com.uti.bwz.core.Constants.Companion.PENJUALAN_TABLE

@Entity(tableName = PENJUALAN_TABLE)
data class Penjualan(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val jumlahbeli: Int,
    val satuan: String,
    val tanggal: String
)