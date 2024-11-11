package com.example.studikasus_room.ui.item

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.studikasus_room.data.ItemsRepository

/*
class diatas berfungsi untuk mengelola data dan state dari tampilan edit item. Class diatas merupakan
perluasan atau pewaris dari class ViewModel. ViewModel ini akan melakukan validasi terhadap input pengguna
sebelum data diperbarui melalui fungsi validateInput() dan akan memperbarui user interface setiap terdapat
perubahan pada variabel itemUiState
 */

class ItemEditViewModel(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    var itemUiState by mutableStateOf(ItemUiState())
        private set

    private val itemId: Int = checkNotNull(savedStateHandle[ItemEditDestination.itemIdArg])

    private fun validateInput(uiState: ItemDetails = itemUiState.itemDetails): Boolean {
        return with(uiState) {
            name.isNotBlank() && price.isNotBlank() && quantity.isNotBlank()
        }
    }
}