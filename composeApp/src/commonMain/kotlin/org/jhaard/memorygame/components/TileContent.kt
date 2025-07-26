package org.jhaard.memorygame.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import org.jetbrains.compose.resources.painterResource
import org.jhaard.memorygame.models.TileData
import org.jhaard.memorygame.models.TileState

/**
 * The image contents of a tile.
 * @param tile The tile data.
 */
@Composable
fun TileContent(
    tile: TileData
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()

    ) {
        Image(
            painter = if (tile.tileState == TileState.FLIP) painterResource(tile.imageContent) else painterResource(tile.backsideImage),
            contentDescription = "Tile content",
            alignment = Alignment.Center,
            contentScale = ContentScale.Crop
        )
    }
}