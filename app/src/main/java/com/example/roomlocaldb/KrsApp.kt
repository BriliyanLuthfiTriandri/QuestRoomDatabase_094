package com.example.roomlocaldb

import android.app.Application
import com.example.roomlocaldb.dependeciesinjection.ContainerApp


class KrsApp : Application() {
    // Fungsinya untuk menyimpan instance ContainerApp
    lateinit var containerApp: ContainerApp

    override fun onCreate(){
        super.onCreate()
        // Membuat Instance ContainerApp
        containerApp = ContainerApp(this)
        // Instance adalah object  yang dibuat dari class
    }
}