package com.example.roomlocaldb.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomlocaldb.data.dao.MahasiswaDao
import com.example.roomlocaldb.data.entity.Mahasiswa

@Database(entities = [Mahasiswa::class], version = 1, exportSchema = false)
abstract class KrsDatabase : RoomDatabase(){

    // Mendefinisikan fungsi untuk mengakses data Mahasiswa
    abstract fun mahasiswaDao() : MahasiswaDao

    companion object {
        @Volatile // Memastikan bahwa nilai variable Instance selalu sama semua thread
        private var Instances: KrsDatabase? =  null

        fun getDatabase(context: Context) : KrsDatabase {
            return (Instances ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    KrsDatabase::class.java, // Class database
                    "KrsDatabase" // Nama Database
                )
                    .build().also { Instances = it }
            })
        }
    }
}