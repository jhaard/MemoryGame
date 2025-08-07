package org.jhaard.memorygame.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import org.jhaard.memorygame.Modules
import org.jhaard.memorygame.screens.GameScreen
import org.jhaard.memorygame.screens.StartScreen
import org.jhaard.memorygame.viewModels.GameViewModel
import org.jhaard.memorygame.viewModels.NewGameViewModelFactory
import org.jhaard.memorygame.viewModels.StartViewModel

/**
 * Navigation with NavHost to the screen routes of the game.
 *
 * @param startViewModel The passed startViewModel.
 */
@Composable
fun Navigation(startViewModel: StartViewModel) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.StartScreen.route,
        modifier = Modifier
    ) {
        composable(route = Screens.StartScreen.route) {
            StartScreen(
                navController = navController,
                navOptions = navOptions(),
                startViewModel = startViewModel
            )
        }
        composable(route = Screens.GameScreen.route) {
            val gameViewModel: GameViewModel = viewModel(
                factory = NewGameViewModelFactory(Modules.gameService)
            )
            GameScreen(
                navController = navController,
                navOptions = navOptions(),
                gameViewModel = gameViewModel
            )
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