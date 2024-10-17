package com.example.myviewmodel.addItemUsingViewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ItemViewModel : ViewModel() {
    private val _item = MutableStateFlow<Item?>(null)
    val item: StateFlow<Item?> = _item

    fun setItem( name: String, description: String) {
        _item.value = Item(name, description)
    }
}

data class Item(
    val name: String = "",
    val description: String = "",
)
