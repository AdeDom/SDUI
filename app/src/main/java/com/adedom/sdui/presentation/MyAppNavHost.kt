package com.adedom.sdui.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.adedom.home.presentation.component.HomeScreen
import com.adedom.movie.presentation.component.MovieScreen
import org.koin.androidx.compose.koinViewModel

@Composable
fun MyAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "home",
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable("home") {
            HomeScreen(
                viewModel = koinViewModel(),
                onNavigateToDetail = {
                    navController.navigate("movie?movieId=$it")
                }
            )
        }
        composable(
            route = "movie?movieId={movieId}",
            arguments = listOf(navArgument("movieId") { type = NavType.IntType })
        ) { backStackEntry ->
            val text = backStackEntry.arguments?.getInt("movieId", -1)
            MovieScreen(text = text.toString())
        }
    }
}