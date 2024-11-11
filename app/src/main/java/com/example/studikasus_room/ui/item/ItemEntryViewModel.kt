package com.example.studikasus_room.ui.item

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.studikasus_room.data.Item
import java.text.NumberFormat


class ItemEntryViewModel : ViewModel() {

    var itemUiState by mutableStateOf(ItemUiState())
        private set

    fun updateUiState(itemDetails: ItemDetails) {
        itemUiState =
            ItemUiState(itemDetails = itemDetails, isEntryValid = validateInput(itemDetails))
    }

    private fun validateInput(uiState: ItemDetails = itemUiState.itemDetails): Boolean {
        return with(uiState) {
            name.isNotBlank() && price.isNotBlank() && quantity.isNotBlank()
        }
    }
}

/*
Class ItemEntryViewModel merupakan perluasan dari class ViewModel dan berfungsi untuk memvalidasi input
pengguna sebelum data tersebut ditambahkan pada database. serta mengelola UI state dari tampilan entry
item.
 */

data class ItemUiState(
    val itemDetails: ItemDetails = ItemDetails(),
    val isEntryValid: Boolean = false
)
/*
data class ItemUiState merepresentasikan UI state. data class ini berisi detail item dan juga boolean
yang merepresentasikan kevalidan data item
 */

data class ItemDetails(
    val id: Int = 0,
    val name: String = "",
    val price: String = "",
    val quantity: String = "",
)
/*
data class ItemDetails merupakan struktur data yang berisi atribut-atribut dari item yaitu ID, name,
price, dan quantity. tipe data dari price dan quantity diubah menjadi string untuk mempermudah interaksi
dan validasi
 */


/*
fungsi-fungsi yang berada dibawah ini merupakan fungsi tambahan yang berguna untuk mengkonversi tipe
data dan struktur data yang dimiliki oleh beberapa atribut terutama price dan quantity. Fungsi ItemDetails.toItem() berfungsi
untuk mengubah struktur data ItemDetails menjadi bentuk Item dimana atribut price dan quantity pada Item
berupa double dan integer. Terdapat pula fungsi Item.formatedPrice() yang berfungsi untuk memformat harga.
fungsi Item.toItemUiState berfungsi untuk mengubah item menjadi ItemUiState. Terakhir terdapat fungsi
Item.toItemDetails yang berfungsi untuk mengubah struktur data item menjadi ItemDetails dimana disini
price dan quantity bertipe data string
 */
fun ItemDetails.toItem(): Item = Item(
    id = id,
    name = name,
    price = price.toDoubleOrNull() ?: 0.0,
    quantity = quantity.toIntOrNull() ?: 0
)

fun Item.formatedPrice(): String {
    return NumberFormat.getCurrencyInstance().format(price)
}

/**
 * Extension function to convert [Item] to [ItemUiState]
 */
fun Item.toItemUiState(isEntryValid: Boolean = false): ItemUiState = ItemUiState(
    itemDetails = this.toItemDetails(),
    isEntryValid = isEntryValid
)

/**
 * Extension function to convert [Item] to [ItemDetails]
 */
fun Item.toItemDetails(): ItemDetails = ItemDetails(
    id = id,
    name = name,
    price = price.toString(),
    quantity = quantity.toString()
)