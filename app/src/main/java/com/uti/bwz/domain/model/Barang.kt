package com.uti.bwz.domain.model

import android.annotation.SuppressLint
import androidx.annotation.Nullable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.uti.bwz.core.Constants.Companion.BARANG_TABLE

@Entity(tableName = BARANG_TABLE)
data class Barang(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val kategori: String,
    @SuppressLint("KotlinNullnessAnnotation") @Nullable
    val modal: Int,
    val harga: Int,
    val satuan: String
)