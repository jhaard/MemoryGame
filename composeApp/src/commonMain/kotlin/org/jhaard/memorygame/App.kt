package org.jhaard.memorygame

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.jhaard.memorygame.components.GameBoard
import org.jhaard.memorygame.viewModels.GameViewModel

/**
 * Starting composable function for the applications.
 *
 * @param gameViewModel The GameViewModel for game flow.
 */
@Composable
@Preview
fun App(gameViewModel: GameViewModel) {

    MaterialTheme {
        GameBoard(gameViewModel = gameViewModel)
    }

}