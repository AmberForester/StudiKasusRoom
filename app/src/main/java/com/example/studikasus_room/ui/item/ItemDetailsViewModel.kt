package com.example.studikasus_room.ui.item

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.studikasus_room.data.ItemsRepository



class ItemDetailsViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val itemId: Int = checkNotNull(savedStateHandle[ItemDetailsDestination.itemIdArg])

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}

/*
class Item DetailViewModel merupakan sebuah class yang memperluas (mewarisi) class ViewModel dan berfungsi
untuk bertanggung jawab atas pengelolaan data yang berkaitan dengan detail item pada aplikasi.
 */

data class ItemDetailsUiState(
    val outOfStock: Boolean = true,
    val itemDetails: ItemDetails = ItemDetails()
)

/*
data class diatas berfungsi untuk mendefinisikan status UI untuk detail item. Data class ini menyimpan
informasi mengenai ketersediaan stock dan detail item yang akan ditampilkan dalam user interface
 */
