package com.example.myviewmodel.shareDataBetweenScreenUsingViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class ProfileDetail (
    var username: String =  "",
    val email: String =  "",
    val position: String =  "",
    val age: Int = 0,
)

class ProfileModel : ViewModel() {

    private val _state = MutableStateFlow(ProfileDetail())
    val state: StateFlow<ProfileDetail> = _state.asStateFlow()

    var background by mutableStateOf(Color.White)

    fun changeBackground() {
        background = Color.LightGray
    }

    fun updatePersonDetail(
        username: String,
        email: String,
        position: String,
        age: Int
    ) {
        _state.value = ProfileDetail(username, email, position, age)
    }
}