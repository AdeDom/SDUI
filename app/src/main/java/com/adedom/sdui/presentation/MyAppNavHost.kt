package com.adedom.sdui.presentation

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.net.toUri
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.adedom.adaptivecards.data.models.Action
import com.adedom.adaptivecards.presentation.component.AdaptiveCardScreen
import com.adedom.home.presentation.component.HomeScreen
import org.koin.androidx.compose.koinViewModel

@Composable
fun MyAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "home"
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable("home") {
            HomeScreen(
                viewModel = koinViewModel(),
                onNavigate = {
                    navController.navigate("sdui/${it.id}")
                }
            )
        }
        composable(
            route = "sdui/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType }),
            deepLinks = listOf(navDeepLink { uriPattern = "sdui://adaptivecards/{id}" })
        ) { backStackEntry ->
            val context = LocalContext.current
            val id = backStackEntry.arguments?.getInt("id")

            AdaptiveCardScreen(
                viewModel = koinViewModel(),
                id = id,
                onClick = { action ->
                    when (action) {
                        is Action.OpenMore -> {
                            context.openDeeplink(action.id)
                        }

                        is Action.OpenUrl -> {
                            try {
                                val intent = Intent(Intent.ACTION_VIEW, action.url?.toUri())
                                context.startActivity(intent)
                            } catch (e: ActivityNotFoundException) {
                                e.printStackTrace()
                            }
                        }

                        is Action.ShowCard -> {
                            context.openDeeplink(action.id)
                        }

                        is Action.Submit -> {
                            context.openDeeplink(action.id)
                        }
                    }
                }
            )
        }
    }
}

private fun Context.openDeeplink(id: Int?) {
    try {
        val deepLinkIntent = Intent(
            Intent.ACTION_VIEW,
            "sdui://adaptivecards/${id}".toUri(),
            this,
            MainActivity::class.java
        )
        this.startActivity(deepLinkIntent)
    } catch (e: ActivityNotFoundException) {
        e.printStackTrace()
    }
}