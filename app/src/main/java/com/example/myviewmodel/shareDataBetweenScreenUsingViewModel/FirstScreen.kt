package com.example.myviewmodel.shareDataBetweenScreenUsingViewModel

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.myviewmodel.Routes

@Composable
fun FirstScreen(
    navController: NavController,
    userViewModel: ProfileModel = viewModel()
) {
    var userName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var position by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        OutlinedTextField(
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth(),
            value = userName,
            onValueChange = {userName = it},
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth(),
            value = password,
            onValueChange = {password = it}
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            label = { Text("Position") },
            modifier = Modifier.fillMaxWidth(),
            value = position,
            onValueChange = {position = it}
        )
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = {
                userViewModel.updatePersonDetail(userName, password, position)
                navController.navigate(Routes.SecondScreen.route)
            },
            modifier = Modifier.fillMaxWidth().padding(top = 32.dp)
        ) {
            Text(text = "Submit")
        }
    }
}