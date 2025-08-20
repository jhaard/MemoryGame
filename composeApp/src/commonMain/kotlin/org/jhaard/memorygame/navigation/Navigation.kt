package org.jhaard.memorygame.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navOptions
import org.jhaard.memorygame.screens.GameScreen
import org.jhaard.memorygame.screens.StartScreen

/**
 * Navigation with NavHost to the screen routes of the game.
 */
@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.StartScreen.route,
        modifier = Modifier
    ) {
        composable(route = Screens.StartScreen.route) {
            StartScreen(
                navController = navController,
                navOptions = navOptions()
            )
        }
        composable(route = Screens.GameScreen.route + "/{key}",
            arguments = listOf(navArgument("key") {
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("key")?.let { set ->
                GameScreen(
                    set = set,
                    navController = navController,
                    navOptions = navOptions()
                )
            }
        }

    }

}

fun navOptions(): NavOptions {
    return navOptions {
        launchSingleTop = true
        restoreState = false
        popUpTo("start_screen") {
            inclusive = false
            saveState = false
        }
    }
}