package org.jhaard.memorygame.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jhaard.memorygame.viewModels.GameViewModel

/**
 * The GameBoard of tiles.
 *
 * @param gameViewModel The viewmodel for the game flow to this view.
 */
@Composable
fun GameBoard(gameViewModel: GameViewModel) {

    val tileList by gameViewModel.tileList.collectAsState(initial = emptyList())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        LazyVerticalGrid(
            columns = GridCells.FixedSize(100.dp),
            state = rememberLazyGridState(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalArrangement = Arrangement.SpaceAround,
        ) {

            item(span = { GridItemSpan(this.maxLineSpan) }) {
                Text(
                    text = "MEMORY GAME",
                    textAlign = TextAlign.Center,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(50.dp)
                )
            }

            items(tileList) { tile ->
                TileComponent(tile = tile, onClick = {

                    gameViewModel.changeTileState(id = tile.id)

                })
            }
        }
    }

}