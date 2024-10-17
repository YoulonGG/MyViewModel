package com.example.myviewmodel.shareDataBetweenScreenUsingViewModel

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun SecondScreen(
    navController: NavController,
    userViewModel: ProfileModel = viewModel()
) {
    val state by userViewModel.state.collectAsState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(userViewModel.background)
    ) {
        Text(
            fontSize = 18.sp,
            text = "Your Username")
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            color = Color.Red,
            fontSize = 24.sp,
            text = state.username,
            modifier = Modifier.padding(start = 8.dp))
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            fontSize = 18.sp,
            text = "Your Email")
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            color = Color.Red,
            fontSize = 24.sp, text = state.email,
            modifier = Modifier.padding(start = 8.dp))
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            fontSize = 18.sp,
            text = "Your Position")
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            color = Color.Red,
            fontSize = 24.sp,
            text = state.position,
            modifier = Modifier.padding(start = 8.dp)
        )
        Text(
            fontSize = 18.sp,
            text = "Your Age")
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            color = Color.Red,
            fontSize = 24.sp,
            text = state.age.toString(),
            modifier = Modifier.padding(start = 8.dp)
        )
        Button(
            onClick = { userViewModel.changeBackground() }
        ) {
            Text(text = "Change background")
        }
    }
}