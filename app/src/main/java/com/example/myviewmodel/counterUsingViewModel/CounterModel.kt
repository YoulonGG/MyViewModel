package com.example.myviewmodel.counterUsingViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CounterModel : ViewModel() {

    var count by mutableIntStateOf(0)

    fun increment() {
        count++
    }

    fun decrement() {
        count--
    }

}