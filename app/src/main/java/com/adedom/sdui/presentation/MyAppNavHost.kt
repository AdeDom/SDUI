package com.adedom.sdui.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.adedom.adaptivecards.data.models.Action
import com.adedom.adaptivecards.presentation.component.AdaptiveCardScreen
import org.koin.androidx.compose.koinViewModel

@Composable
fun MyAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "main"
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable("main") {
            AdaptiveCardScreen(
                viewModel = koinViewModel(),
                onClick = { action ->
                    when (action) {
                        is Action.OpenMore -> {
                            navController.navigate("details/${action.id}")
                        }

                        is Action.OpenUrl -> {
                            navController.navigate("details/${action.id}")
                        }

                        is Action.ShowCard -> {
                            navController.navigate("details/${action.id}")
                        }

                        is Action.Submit -> {
                            navController.navigate("details/${action.id}")
                        }
                    }
                }
            )
        }
        composable("details/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id")

            AdaptiveCardScreen(
                viewModel = koinViewModel(),
                id = id,
                onClick = { action ->
                    when (action) {
                        is Action.OpenMore -> {
                            navController.navigate("details/${action.id}")
                        }

                        is Action.OpenUrl -> {
                            navController.navigate("details/${action.id}")
                        }

                        is Action.ShowCard -> {
                            navController.navigate("details/${action.id}")
                        }

                        is Action.Submit -> {
                            navController.navigate("details/${action.id}")
                        }
                    }
                }
            )
        }
    }
}