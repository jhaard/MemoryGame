package org.jhaard.memorygame.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import org.jhaard.memorygame.models.GameState
import org.jhaard.memorygame.viewModels.GameViewModel
import org.kodein.di.compose.localDI
import org.kodein.di.direct
import org.kodein.di.instance

/**
 * The GameScreen with the TileBoard.
 *
 * @param navController For navigation.
 * @param navOptions Navigation options.
 */
@Composable
fun GameScreen(navController: NavController, navOptions: NavOptions) {

    val di = localDI()
    val gameViewModel: GameViewModel = di.direct.instance()

    val tileList by gameViewModel.tileList.collectAsState(initial = emptyList())
    val uiState by gameViewModel.uiState.collectAsState(initial = GameState.Initial)

    when (uiState) {
        is GameState.Error -> ErrorScreen()
        is GameState.GameOver -> GameOverScreen(
            navController = navController, navOptions = navOptions,
            score = (uiState as GameState.GameOver).score,
            onClick = {
                gameViewModel.resetGame()
            }
        )

        is GameState.Initial -> InitialScreen()
        is GameState.Playing -> PlayScreen(
            tileList = tileList,
            timer = (uiState as GameState.Playing).timer.toString(),
            onClick = { tile ->
                gameViewModel.flipTile(
                    tileId = tile.id,
                    imageUrl = tile.imageContent
                )
            })

    }

}