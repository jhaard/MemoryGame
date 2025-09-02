package org.jhaard.memorygame.animations

import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import org.jhaard.memorygame.models.TileData
import org.jhaard.memorygame.models.TileState


@Composable
fun scaleTileAnimation(tile: TileData): Float {
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
fun rotateTileAnimation(tile: TileData): Float {
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

@Composable
fun spinningAnimation(target: Float, easing: Easing, repeatMode: RepeatMode): Float {
    val infiniteTransition = rememberInfiniteTransition(label = "spin")

    val rotation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = target,
        animationSpec = infiniteRepeatable(
            animation = tween(6000, easing = easing),
            repeatMode = repeatMode
        ),
        label = "spin"
    )
    return rotation

}

@Composable
fun alphaAnimation(): Float {
    val infiniteTransition = rememberInfiniteTransition(label = "alpha")

    val alpha by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 0.8f,
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "alpha"
    )
    return alpha

}
@Composable
fun scaleAnimation(): Float {
    val infiniteTransition = rememberInfiniteTransition(label = "general_scale")

    val scale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.04f,
        animationSpec = infiniteRepeatable(
            animation = tween(300, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "general_scale"
    )
    return scale

}

