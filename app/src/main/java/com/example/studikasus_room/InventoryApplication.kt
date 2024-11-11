package com.example.studikasus_room

import android.app.Application
import com.example.studikasus_room.data.AppContainer
import com.example.studikasus_room.data.AppDataContainer
/*
Class inventoryApplication merupakan sebuah class yang menjadi child class atau sub class dari Application.
class ini berfungsi untuk menyediakan instance dari AppContainer sebagai kontainer yang meliputi seluruh aplikasi.
Dengan memanggil class ini, maka appContainer hanya perlu dipanggil sekali saat aplikasi berjalan.
class ini juga melakukan override pada fungsi onCreate() sekaligus menginisialisasi container pada fungsi ini

 */
class InventoryApplication: Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}