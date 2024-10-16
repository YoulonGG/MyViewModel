package com.example.myviewmodel.addItemUsingViewModel

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.myviewmodel.Routes

@Composable
fun AddFruitScreen(
    navController: NavController,
    fruitViewModel: FruitViewModel = viewModel()
) {

    var fruitName by remember { mutableStateOf("") }
    var fruitDescription by remember { mutableStateOf("") }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(16.dp).fillMaxSize()
    ) {
        OutlinedTextField(
            value = fruitName,
            onValueChange = { fruitName = it },
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )
        OutlinedTextField(
            value = fruitDescription,
            onValueChange = { fruitDescription = it },
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )
        Row(modifier = Modifier.fillMaxWidth()) {
            Button(onClick = {
                if (fruitName.isNotBlank()) {
                    fruitViewModel.addFruit(fruitName, fruitDescription)
                    fruitName = ""
                }
            }) {
                Text("Add Fruit")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = { navController.navigate(Routes.ListFruitScreen.route) }
            ) {
                Text(text = "See the Basket")
            }
        }

    }
}
