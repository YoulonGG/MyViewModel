package com.example.myviewmodel

import AddFruitScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myviewmodel.addItemUsingViewModel.ItemViewModel
import com.example.myviewmodel.addItemUsingViewModel.ListFruitScreen
import com.example.myviewmodel.shareDataBetweenScreenUsingViewModel.FirstScreen
import com.example.myviewmodel.shareDataBetweenScreenUsingViewModel.ProfileModel
import com.example.myviewmodel.shareDataBetweenScreenUsingViewModel.SecondScreen
import com.example.myviewmodel.ui.theme.MyViewModelTheme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyViewModelTheme {
                Navigation()
//                WeatherView(viewModel())
            }
        }
    }
}

data class Weather(
    val city: String,
    val temperature: Int
)

class WeatherViewModel : ViewModel() {
    private val _uiState: MutableStateFlow<Weather> = MutableStateFlow(Weather("No Data", 0))
    val uiState = _uiState.asStateFlow()

    fun fetchWeather() {
        _uiState.value = Weather("Phnom Penh", 27)
    }
}

@Composable
fun WeatherView(
    weatherViewModel: WeatherViewModel
) {
    val weather by weatherViewModel.uiState.collectAsStateWithLifecycle()
    val items = listOf(weather.city, weather.temperature)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            onClick = { weatherViewModel.fetchWeather() }
        ) {
            Text(text = "Update Weather")
        }
        LazyColumn {
            items(items.size) {
                Text(
                    text = "City : ${ weather.city }",
                    style = MaterialTheme.typography.displaySmall,
                    textAlign = TextAlign.Start)
                Text(
                    text = "Temperature : ${ weather.temperature }",
                    style = MaterialTheme.typography.displaySmall,
                    textAlign = TextAlign.Start)
            }
        }
//        Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp)) {
//            Text(text = "City : ${ weather.city }", style = MaterialTheme.typography.displayMedium)
//            Text(text = "Temperature : ${ weather.temperature }", style = MaterialTheme.typography.displayMedium)
//
//        }
    }
}


@Composable
fun Navigation(
    userViewModel: ProfileModel = viewModel(),
    fruitViewModel: ItemViewModel  = viewModel()
){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "fruit") {

        composable(Routes.FirstScreen.route) {
            FirstScreen(navController = navController, userViewModel = userViewModel)
        }
        composable(Routes.SecondScreen.route) {
            SecondScreen(navController = navController, userViewModel = userViewModel)
        }
        composable(Routes.AddFruitScreen.route) {
            AddFruitScreen(navController = navController, fruitViewModel = fruitViewModel)
        }
        composable(Routes.ListFruitScreen.route) {
            ListFruitScreen(fruitViewModel = fruitViewModel)
        }
    }
}

sealed class Routes(val route: String) {
    data object FirstScreen : Routes("first")
    data object SecondScreen : Routes("second")
    data object AddFruitScreen : Routes("fruit")
    data object ListFruitScreen : Routes("list")
}