package com.example.myviewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myviewmodel.addItemUsingViewModel.AddFruitScreen
import com.example.myviewmodel.addItemUsingViewModel.FruitViewModel
import com.example.myviewmodel.addItemUsingViewModel.ListFruitScreen
import com.example.myviewmodel.shareDataBetweenScreenUsingViewModel.FirstScreen
import com.example.myviewmodel.shareDataBetweenScreenUsingViewModel.ProfileModel
import com.example.myviewmodel.shareDataBetweenScreenUsingViewModel.SecondScreen
import com.example.myviewmodel.ui.theme.MyViewModelTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyViewModelTheme {
                Navigation()
            }
        }
    }
}

@Composable
fun Navigation(
    userViewModel: ProfileModel = viewModel(),
    fruitViewModel: FruitViewModel  = viewModel()
){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "first") {

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