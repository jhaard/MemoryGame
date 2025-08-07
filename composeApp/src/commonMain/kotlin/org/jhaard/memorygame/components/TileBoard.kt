package org.jhaard.memorygame.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jhaard.memorygame.models.TileData
import org.jhaard.memorygame.models.TileState

/**
 * The TileBoard composable.
 * @param onClick The tile at onClick.
 * @param tileList The tile list to use.
 * @param timer The visible timer.
 */


@Composable
fun TileBoard(onClick: (TileData) -> Unit, tileList: List<TileData>, timer: String) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(5),
        state = rememberLazyGridState(),
        horizontalArrangement = Arrangement.Start,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
    ) {

        item(span = { GridItemSpan(this.maxLineSpan) }) {

            Row(
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.padding(horizontal = 20.dp)
            ) {
                Text(
                    text = "Time left:",
                    textAlign = TextAlign.End,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.LightGray,
                    modifier = Modifier

                )
                Text(
                    text = timer,
                    textAlign = TextAlign.End,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Red,
                    modifier = Modifier
                )
            }
        }

        items(tileList) { tile ->
            TileComponent(
                tile = tile,
                onClick = { onClick(tile) },
                enabled = tile.tileState == TileState.IDLE
            )
        }

    }

}