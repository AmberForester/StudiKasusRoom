package com.example.studikasus_room.ui

import android.app.Application
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.studikasus_room.InventoryApplication
import com.example.studikasus_room.ui.home.HomeViewModel
import com.example.studikasus_room.ui.item.ItemDetailsViewModel
import com.example.studikasus_room.ui.item.ItemEditViewModel
import com.example.studikasus_room.ui.item.ItemEntryViewModel

/*
kode berikut mendefinisikan objek AppViewModelProvider yang menyediakan sebuah Factory untuk menginisialisasi
berbagai viewModel dengan menggunakan viewModelFactory. Beberapa ViewModel diinisialisasi dengan
SavedStateHandle untuk mempertahankan data penting yang bisa diakses melalui navigasi.
 */
object AppViewModelProvider {
    val Factory = viewModelFactory {
        // Initializer for ItemEditViewModel
        initializer {
            ItemEditViewModel(
                this.createSavedStateHandle()
            )
        }
        // Initializer for ItemEntryViewModel
        initializer {
            ItemEntryViewModel()
        }

        // Initializer for ItemDetailsViewModel
        initializer {
            ItemDetailsViewModel(
                this.createSavedStateHandle()
            )
        }

        // Initializer for HomeViewModel
        initializer {
            HomeViewModel()
        }
    }
}

/**
 * Extension function to queries for [Application] object and returns an instance of
 * [InventoryApplication].
 */
/*
Fungsi ekstensi dibawah ini berfungsi untuk mengambil objek dari CreationExtras dan mengembalikannya
sebagai Inventory Application. Hal tersebut berguna untuk memudahkan akses ke instance application.
 */
fun CreationExtras.inventoryApplication(): InventoryApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as InventoryApplication)