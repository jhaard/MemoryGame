package org.jhaard.memorygame.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import org.jhaard.memorygame.components.GameOverView
import org.jhaard.memorygame.components.TileBoard
import org.jhaard.memorygame.viewModels.GameViewModel
import org.kodein.di.compose.localDI
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
    val gameViewModel: GameViewModel by di.instance()

    val score by gameViewModel.score.collectAsState()
    val timer by gameViewModel.timer.collectAsState()
    val isRunning by gameViewModel.isRunning.collectAsState()

    val tileList by gameViewModel.tileList.collectAsState(initial = emptyList())

    var clickCount by remember { mutableStateOf(0) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF232323))
    ) {
        if (isRunning) {
            TileBoard(onClick = { tile ->
                clickCount++

                gameViewModel.runGameFlow(
                    tileId = tile.id,
                    imageUrl = tile.imageContent,
                    clickCount = clickCount
                )

                if (clickCount == 2) {
                    clickCount = 0
                }

            }, tileList = tileList, timer = timer.toString())

        } else {
            GameOverView(navController = navController, navOptions = navOptions, score = score)
        }
    }

}