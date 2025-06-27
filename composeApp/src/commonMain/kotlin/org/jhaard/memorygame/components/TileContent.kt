package org.jhaard.memorygame.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale

/**
 * The content to be paired.
 * @param imageContent The image content.
 * @param backsideImage The default backside image of the tile.
 * @param showContent showing the content after a slight delay of the animation.
 */
@Composable
fun TileContent(imageContent: Painter, backsideImage: Painter, showContent: Boolean) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .graphicsLayer {
                rotationY = 180f
            }
    ) {
        Image(
            painter = if (showContent) imageContent else backsideImage,
            contentDescription = "Tile content",
            alignment = Alignment.Center,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .graphicsLayer {
                    rotationY = 180f
                }
        )

    }
}