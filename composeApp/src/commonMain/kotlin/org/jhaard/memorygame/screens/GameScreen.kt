package org.jhaard.memorygame.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import org.jhaard.memorygame.components.TileComponent
import org.jhaard.memorygame.models.TileState
import org.jhaard.memorygame.viewModels.GameViewModel

/**
 * The GameBoard of tiles.
 *
 * @param navController For navigation.
 * @param gameViewModel The viewmodel for the game flow to this view.
 */
@Composable
fun GameScreen(navController: NavController, gameViewModel: GameViewModel) {

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
            .background(Color.Black)
    ) {
        if (isRunning) {
            LazyVerticalGrid(
                columns = GridCells.FixedSize(100.dp),
                state = rememberLazyGridState(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalArrangement = Arrangement.SpaceAround,
            ) {

                item(span = { GridItemSpan(this.maxLineSpan) }) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier.padding(top = 40.dp)
                    ) {
                        Text(
                            text = "Time: $timer",
                            textAlign = TextAlign.Center,
                            fontSize = 28.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Red,
                            modifier = Modifier
                        )
                    }
                }

                items(tileList) { tile ->
                    TileComponent(tile = tile, onClick = {

                        clickCount++

                        gameViewModel.runGameFlow(
                            tileId = tile.id,
                            imageUrl = tile.imageContent,
                            clickCount = clickCount
                        )

                        if (clickCount == 2) {
                            clickCount = 0
                        }

                    }, enabled = tile.tileState == TileState.IDLE)
                }
            }
        } else {
            Text(text = "GAME OVER", textAlign = TextAlign.Center, color = Color.Green)
            Text(text = "Your Score: $score", textAlign = TextAlign.Center, color = Color.LightGray)
            Button(
                onClick = ({
                    navController.navigate("game_screen")
                }),
                colors = ButtonColors(
                    containerColor = Color.White,
                    contentColor = Color.Gray,
                    disabledContainerColor = Color.LightGray,
                    disabledContentColor = Color.Gray
                ),
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Retry",
                    fontSize = 18.sp,
                    color = Color.Gray,
                    textAlign = TextAlign.Center
                )
            }
        }
    }

}