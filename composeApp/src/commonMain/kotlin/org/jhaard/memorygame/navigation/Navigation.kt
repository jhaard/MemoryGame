package org.jhaard.memorygame.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.jhaard.memorygame.ModuleDI
import org.jhaard.memorygame.screens.GameBoard
import org.jhaard.memorygame.screens.StartScreen
import org.jhaard.memorygame.viewModels.StartViewModel


/**
 * Navigation with NavHost to the screen routes of the game.
 *
 * @param startViewModel The passed viewModel to start with.
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
                startViewModel = startViewModel
            )
        }
        composable(route = Screens.GameScreen.route) {
            GameBoard(
                navController = navController,
                gameViewModel = ModuleDI.gameViewModel
            )
        }

    }

}