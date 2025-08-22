package org.jhaard.memorygame.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import org.jhaard.memorygame.RememberLifecycleObserver
import org.jhaard.memorygame.models.GameState
import org.jhaard.memorygame.screens.views.ErrorView
import org.jhaard.memorygame.screens.views.GameOverView
import org.jhaard.memorygame.screens.views.InitialView
import org.jhaard.memorygame.screens.views.PlayView
import org.jhaard.memorygame.viewModels.GameViewModel
import org.kodein.di.compose.viewmodel.rememberViewModel

/**
 * The GameScreen with the TileBoard.
 *
 * @param navController For navigation.
 * @param navOptions Navigation options.
 */
@Composable
fun GameScreen(set: String, navController: NavController, navOptions: NavOptions) {

    val gameViewModel: GameViewModel by rememberViewModel(arg = set)

    val tileList by gameViewModel.tileList.collectAsState(initial = emptyList())
    val uiState by gameViewModel.uiState.collectAsState(initial = GameState.Initial)

    LaunchedEffect(Unit) {
        gameViewModel.startMusic()
    }

    RememberLifecycleObserver(
        onStart = { gameViewModel.startMusic() },
        onStop = { gameViewModel.stopMusic() }
    )

    when (uiState) {
        is GameState.Error -> ErrorView(onBack = {
            navController.navigate("start_screen", navOptions)
        })

        is GameState.GameOver -> GameOverView(
            score = (uiState as GameState.GameOver).score,
            onRetry = {
                gameViewModel.stopMusic()
                gameViewModel.resetGame(key = set)
            },
            onBack = {
                navController.navigate("start_screen", navOptions)
            }
        )

        is GameState.Initial -> InitialView()
        is GameState.Playing -> PlayView(
            tileList = tileList,
            timer = (uiState as GameState.Playing).timer.toString(),
            onClick = { tile ->
                gameViewModel.flipTile(
                    tileId = tile.id,
                    imageUrl = tile.imageContent
                )
            }
        )

    }

}