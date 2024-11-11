package com.example.studikasus_room.ui.home

import androidx.lifecycle.ViewModel
import com.example.studikasus_room.data.Item

/*
HomeViewModel merupakan perluasan dari class ViewModel yang berfungsi untuk mengelola UI state untuk
HomeScreen atau beranda dalam aplikasi. Di sisi lain data class HomeUiState merupakan data class
yang berfungsi untuk menyimpan UI state dalam sebuah objek sehingga lebih mudah dikelola
 */
class HomeViewModel : ViewModel() {
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}

data class HomeUiState(val itemList: List<Item> = listOf())