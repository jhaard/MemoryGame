package org.jhaard.memorygame.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import memorygame.composeapp.generated.resources.Res
import memorygame.composeapp.generated.resources.tile_backside
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
        val painterFront = asyncPainterResource(tile.imageContent)
        val painterBack = painterResource(Res.drawable.tile_backside)

        if (tile.tileState == TileState.FLIP) {
            KamelImage({ painterFront },
                contentDescription = "Tile Content",
                contentScale = ContentScale.Crop,
                onFailure = {
                    DefaultImage(painterBack)
                }
            )
        } else {
            DefaultImage(painterBack)
        }
    }
}

/**
 * Default backside image
 */
@Composable
fun DefaultImage(painterBack: Painter) {
    Image(
        painter = painterBack,
        contentDescription = "Tile default image",
        contentScale = ContentScale.Crop
    )
}