package org.jhaard.memorygame.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import org.jhaard.memorygame.animations.rotateTileAnimation
import org.jhaard.memorygame.animations.scaleTileAnimation
import org.jhaard.memorygame.display.Orientation
import org.jhaard.memorygame.display.getTileSize
import org.jhaard.memorygame.models.TileData
import org.jhaard.memorygame.models.TileState
import org.jhaard.memorygame.uiTheme.AppBorderSizing
import org.jhaard.memorygame.uiTheme.AppCardElevation
import org.jhaard.memorygame.uiTheme.AppShapes
import org.jhaard.memorygame.uiTheme.AppSpacing
import org.jhaard.memorygame.uiTheme.ForegroundColor
import org.jhaard.memorygame.uiTheme.TileFlipBorderColor
import org.jhaard.memorygame.uiTheme.TileMatchBorderColor
import org.kodein.di.compose.localDI
import org.kodein.di.instance
import kotlin.random.Random

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
    val di = localDI()
    val orientation by di.instance<Orientation>()

    val randomRotation = remember { randomCardRotation() }

    val scaleAnimation = scaleTileAnimation(tile)
    val rotateAnimation = rotateTileAnimation(tile)

    val screenSize = orientation.getScreenSize()

    Card(
        modifier = Modifier
            .size(getTileSize(screenSize = screenSize))
            .rotate(randomRotation)
            .pointerInput(enabled){
                if (enabled) {
                    detectTapGestures(
                        onPress = { onClick() }
                    )
                }
            }
            .graphicsLayer {
                scaleX = scaleAnimation
                scaleY = scaleAnimation
                rotationZ = rotateAnimation
            }
            .padding(AppSpacing.small),
        shape = AppShapes.small,
        colors = CardColors(
            containerColor = if (tile.tileState == TileState.FLIP) MaterialTheme.colorScheme.onPrimary
            else MaterialTheme.colorScheme.primary,
            contentColor = if (tile.tileState == TileState.FLIP) MaterialTheme.colorScheme.onPrimary
            else MaterialTheme.colorScheme.primary,
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

fun getTileBorder(tileState: TileState): BorderStroke {
    return when (tileState) {
        TileState.IDLE -> BorderStroke(
            width = AppBorderSizing.small,
            color = ForegroundColor,
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


fun randomCardRotation(): Float {
    return if (Random.nextBoolean()) {
        Random.nextDouble(345.0, 360.0).toFloat()
    } else {
        Random.nextDouble(0.0, 15.0).toFloat()
    }
}