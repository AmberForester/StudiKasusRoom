package com.example.studikasus_room.data

/*
    Class item berikut merupakan sebuah representasi dari entitas pada database. masing-masing dari
    atribut yang dimiliki oleh class item ini mewakili kolom pada tabel database dan setiap instance
    (objek) akan menjadi baris dari tabel.
 */

class Item (
    val id: Int = 0,
    val name: String,
    val price: Double,
    val quantity: Int
)


