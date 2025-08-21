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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jhaard.memorygame.models.TileData
import org.jhaard.memorygame.models.TileState
import org.jhaard.memorygame.uiTheme.AppSpacing

/**
 * The TileBoard composable.
 * @param onClick The tile at onClick.
 * @param tileList The tile list to use.
 * @param timer The visible timer.
 */


@Composable
fun TileBoard(onClick: (TileData) -> Unit, tileList: List<TileData>, timer: String) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        state = rememberLazyGridState(),
        horizontalArrangement = Arrangement.Start,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(AppSpacing.xSmall)
    ) {

        item(span = { GridItemSpan(this.maxLineSpan) }) {

            Row(
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.padding(horizontal = AppSpacing.medium)
            ) {
                Text(
                    text = "Time left:",
                    style = MaterialTheme.typography.headlineSmall
                )
                Text(
                    text = timer,
                    style = MaterialTheme.typography.titleLarge
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