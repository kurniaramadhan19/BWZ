package com.uti.bwz.core

class Constants {
    companion object {
        //Room
        const val BARANG_TABLE = "barang_table"
        const val PENJUALAN_TABLE = "penjualan_table"

        //Screens
        const val BARANGS_SCREEN = "Barang"
        const val UPDATE_BARANG_SCREEN = "Update barang"
        const val PENJUALANS_SCREEN = "Penjualan"
        const val UPDATE_PENJUALAN_SCREEN = "Penjualan barang"

        //Arguments
        const val BARANG_ID = "barangId"
        const val PENJUALAN_ID = "penjualanId"

        //Actions
        const val ADD_BARANG = "Tambah data barang."
        const val DELETE_BARANG = "Hapus data barang."
        const val SEARCH_BARANG = "cari data barang."
        const val ADD_PENJUALAN = "Tambah data penjualan."
        const val DELETE_PENJUALAN = "Hapus data penjualan."
        const val SEARCH_PENJUALAN = "cari data penjualan."

        //Buttons
        const val ADD = "Tambah"
        const val DISMISS = "Batal"
        const val UPDATE = "Simpan"
        const val ADD_JUAL = "Tambah"
        const val DISMISS_JUAL = "Batal"
        const val UPDATE_JUAL = "Simpan"

        //Placeholders
        const val BARANG_NAME = "Isi Nama Barang..."
        const val KATEGORI = "Isi Nama Kategori Barang..."
        const val MODAL = "Isi Modal Barang..."
        const val HARGA = "Isi Harga Barang..."
        const val SATUAN = "Isi Satuan Barang..."
        const val NO_VALUE = ""
    }
}