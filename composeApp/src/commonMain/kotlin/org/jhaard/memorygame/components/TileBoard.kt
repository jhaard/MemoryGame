package org.jhaard.memorygame.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
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
 * @param onClick The tile onClick.
 * @param tileList The tile list to use.
 * @param timer The visible timer.
 */


@Composable
fun TileBoard(onClick: (TileData) -> Unit, tileList: List<TileData>, timer: String) {
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
            TileComponent(
                tile = tile,
                onClick = { onClick(tile) },
                enabled = tile.tileState == TileState.IDLE
            )
        }

    }

}