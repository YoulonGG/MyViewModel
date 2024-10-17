package com.example.myviewmodel.addItemUsingViewModel

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun ListFruitScreen(
    fruitViewModel:
    ItemViewModel) {
    val item by fruitViewModel.item.collectAsState()

    val items = listOf(Item("Apple", "Red Apple"))

    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        items(items.size) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Name: ${item?.name}",
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Start)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Description: ${item?.description}",
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Start)
        }
    }
}

