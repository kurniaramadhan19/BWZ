package com.uti.bwz.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import com.uti.bwz.core.Constants.Companion.BARANG_TABLE
import com.uti.bwz.core.Constants.Companion.PENJUALAN_TABLE
import com.uti.bwz.data.network.BarangDao
import com.uti.bwz.data.network.BarangDb
import com.uti.bwz.data.network.PenjualanDao
import com.uti.bwz.data.repository.BarangRepositoryImpl
import com.uti.bwz.data.repository.PenjualanRepositoryImpl
import com.uti.bwz.domain.repository.BarangRepository
import com.uti.bwz.domain.repository.PenjualanRepository

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideBarangDb(
        @ApplicationContext
        context : Context
    ) = Room.databaseBuilder(
        context,
        BarangDb::class.java, "barang_db"
    ).build()

    @Provides
    fun provideBarangDao(
        barangDb: BarangDb
    ) = barangDb.barangDao()

    @Provides
    fun provideBarangRepository(
        barangDao: BarangDao
    ): BarangRepository = BarangRepositoryImpl(
        barangDao = barangDao
    )

    @Provides
    fun providePenjualanDao(
        barangDb: BarangDb
    ) = barangDb.penjualanDao()

    @Provides
    fun providePenjualanRepository(
        penjualanDao: PenjualanDao
    ): PenjualanRepository = PenjualanRepositoryImpl(
        penjualanDao = penjualanDao
    )
}