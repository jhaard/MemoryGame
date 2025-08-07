package org.jhaard.memorygame

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import org.jhaard.memorygame.models.TileData
import org.jhaard.memorygame.models.TileState


@Composable
fun scaleTile(tile: TileData): Float {
    val transition = updateTransition(tile.tileState, label = "transition")
    val scale by transition.animateFloat(
        transitionSpec = {
            tween(200)
        },
        label = "scale"
    ) { state ->
        when (state) {
            TileState.IDLE -> 1f
            TileState.FLIP -> 1.25f
            TileState.MATCHED -> 1.25f
        }
    }
    return scale
}

@Composable
fun rotateTile(tile: TileData): Float {
    val transition = updateTransition(tile.tileState, label = "transition")

    val rotate by transition.animateFloat(
        transitionSpec = {
            tween(500)
        },
        label = "rotate"
    ) { state ->
        when (state) {
            TileState.IDLE -> 0f
            TileState.FLIP -> 0f
            TileState.MATCHED -> 360f
        }
    }
    return rotate
}
