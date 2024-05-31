package com.example.madarsof.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument


sealed class Destinations(
    val route: String
) {
    object InputScreen : Destinations("InputScreen")
    object DisplayScreen : Destinations("DisplayScreen")
}

