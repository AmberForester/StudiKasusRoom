package com.example.studikasus_room.data

import android.content.Context

/*
Pada file ini terdapat dua bagian yaitu interface AppContainer dan class AppDataContainer. Sesuai
dengan namanya, Interface AppContainer berfungsi sebagai kontainer aplikasi yang mendefinisikan itemsRepository
yang merupakan instance dari ItemsRepository. Sedangkan class AppDataContainer merupakan class yang
mengimplementasikan interface container. class ini mendefinisikan instance konkret dari ItemsRepository
yang dipanggil melalui class OfflineItemsRepository. Lazy artinya instance akan dibuat sekali ketika
akan digunakan
 */

interface AppContainer {
    val itemsRepository: ItemsRepository
}

class AppDataContainer(private  val context: Context): AppContainer {

    override val itemsRepository: ItemsRepository by lazy {
        OfflineItemsRepository()
    }
}