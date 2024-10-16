package com.example.myviewmodel.addItemUsingViewModel

import android.media.Image
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel


class FruitViewModel : ViewModel() {
    private val _fruit = mutableStateListOf(Fruit())
    val fruit: List<Fruit> = _fruit

    fun addFruit(name: String, des: String) {

    }
}

data class Fruit(
    val name: String = "",
    val des: String = ""
)
