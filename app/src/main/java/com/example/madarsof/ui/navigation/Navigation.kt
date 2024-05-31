package com.example.madarsof.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.madarsof.ui.screen.UserViewModel
import com.example.madarsof.ui.screen.DisplayScreen
import com.example.madarsof.ui.screen.InputScreen

@Composable
fun MainAppGraph() {

    val navController = rememberNavController()
    val userViewModel : UserViewModel = hiltViewModel()
    NavHost(
        navController = navController,
        startDestination = Destinations.InputScreen.route,
        modifier = Modifier.fillMaxSize()
    ) {
       composable(Destinations.InputScreen.route){
           InputScreen(userViewModel = userViewModel, navController = navController)
       }
        composable(Destinations.DisplayScreen.route){
            DisplayScreen(userViewModel = userViewModel)
        }
    }
}