package com.adedom.sdui.presentation

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.adedom.adaptivecards.presentation.component.AdaptiveCardScreen
import com.adedom.home.presentation.component.HomeScreen
import com.adedom.movie.presentation.component.MovieScreen
import org.koin.androidx.compose.koinViewModel

@Composable
fun MyAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "adaptive-card"
) {
    val context = LocalContext.current

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable("adaptive-card") {
            AdaptiveCardScreen(
                viewModel = koinViewModel(),
                onClick = { component ->
                    Toast.makeText(context, component.toString(), Toast.LENGTH_SHORT).show()
                }
            )
        }
        composable("home") {
            HomeScreen(
                viewModel = koinViewModel(),
                onNavigateToDetail = {
                    navController.navigate("movie?key=$it")
                }
            )
        }
        composable(
            route = "movie?key={key}",
            arguments = listOf(navArgument("key") { type = NavType.StringType })
        ) { backStackEntry ->
            val text = backStackEntry.arguments?.getString("key")
            MovieScreen(text = text.toString())
        }
    }
}