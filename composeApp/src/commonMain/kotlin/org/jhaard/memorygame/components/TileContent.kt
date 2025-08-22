package org.jhaard.memorygame.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import memorygame.composeapp.generated.resources.Res
import memorygame.composeapp.generated.resources.diamond_shape_backside
import org.jetbrains.compose.resources.painterResource
import org.jhaard.memorygame.models.TileData
import org.jhaard.memorygame.models.TileState
import org.jhaard.memorygame.uiTheme.AppSpacing

/**
 * The image contents of a tile.
 *
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
        val painterBack = painterResource(Res.drawable.diamond_shape_backside)

        if (tile.tileState == TileState.FLIP || tile.tileState == TileState.MATCHED) {
            KamelImage({ painterFront },
                contentDescription = "Tile Content",
                contentScale = ContentScale.Crop,
                modifier = Modifier.padding(AppSpacing.xSmall),
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
 * Default backside image, should be an internal asset.
 *
 * @param painterBack the Painter object of the backside image.
 */
@Composable
fun DefaultImage(painterBack: Painter) {
    Image(
        painter = painterBack,
        contentDescription = "Tile default image",
        contentScale = ContentScale.Crop
    )
}