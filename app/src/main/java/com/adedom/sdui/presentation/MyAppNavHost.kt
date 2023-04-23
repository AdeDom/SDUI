package com.adedom.sdui.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.adedom.adaptivecards.presentation.component.AdaptiveCardScreen
import org.koin.androidx.compose.koinViewModel

@Composable
fun MyAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "adaptive-card"
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable("adaptive-card") {
            AdaptiveCardScreen(
                viewModel = koinViewModel(),
                onClick = { component ->
                    navController.navigate("adaptive-card")
                }
            )
        }
    }
}