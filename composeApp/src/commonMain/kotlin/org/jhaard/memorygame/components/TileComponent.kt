package org.jhaard.memorygame.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import org.jhaard.memorygame.animations.rotateTileAnimation
import org.jhaard.memorygame.animations.scaleTileAnimation
import org.jhaard.memorygame.models.TileData
import org.jhaard.memorygame.models.TileState
import org.jhaard.memorygame.uiTheme.AppBorderSizing
import org.jhaard.memorygame.uiTheme.AppCardElevation
import org.jhaard.memorygame.uiTheme.AppImageSizing
import org.jhaard.memorygame.uiTheme.AppShapes
import org.jhaard.memorygame.uiTheme.AppSpacing
import org.jhaard.memorygame.uiTheme.PrimaryGradient
import org.jhaard.memorygame.uiTheme.TileFlipBorderColor
import org.jhaard.memorygame.uiTheme.TileMatchBorderColor

/**
 * A Memory Tile Component.
 *
 * @param tile The data of the tile.
 * @param onClick The click event of the tile.
 */
@Composable
fun TileComponent(
    tile: TileData,
    onClick: () -> Unit,
    enabled: Boolean
) {
    val scaleAnimation = scaleTileAnimation(tile)
    val rotateAnimation = rotateTileAnimation(tile)

    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Card(
            modifier = Modifier
                .size(AppImageSizing.tileSize)
                .clickable(onClick = onClick, enabled = enabled)
                .graphicsLayer {
                    scaleX = scaleAnimation
                    scaleY = scaleAnimation
                    rotationZ = rotateAnimation
                }
                .padding(AppSpacing.small),
            shape = AppShapes.medium,
            colors = CardColors(
                containerColor = if (tile.tileState == TileState.FLIP) Color.White else Color.Gray,
                contentColor = if (tile.tileState == TileState.FLIP) Color.White else Color.Gray,
                disabledContainerColor = Color.LightGray,
                disabledContentColor = Color.LightGray
            ),
            elevation = CardDefaults.cardElevation(AppCardElevation.small),
            border = getTileBorder(tile.tileState)
        ) {
            TileContent(
                tile = tile
            )
        }
    }

}

fun getTileBorder(tileState: TileState): BorderStroke {
    return when (tileState) {
        TileState.IDLE -> BorderStroke(
            brush = PrimaryGradient,
            width = AppBorderSizing.small,
        )
        TileState.FLIP -> BorderStroke(
            width = AppBorderSizing.large,
            color = TileFlipBorderColor
        )
        TileState.MATCHED -> BorderStroke(
            width = AppBorderSizing.large,
            color = TileMatchBorderColor
        )
    }
}