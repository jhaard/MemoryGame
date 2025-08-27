package org.jhaard.memorygame.animations

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue


@Composable
fun moveAnimation(visible: Boolean): Float {
    val offsetY by animateFloatAsState(
        targetValue = if (visible) 0f else +200f,
        animationSpec = tween(1000),
        label = "offsetY"
    )
    return offsetY
}

@Composable
fun textAlphaAnimation(visible: Boolean): Float {
    val alpha by animateFloatAsState(
        targetValue = if (visible) 1f else 0f,
        animationSpec = tween(1000),
        label = "alpha"
    )
    return alpha
}