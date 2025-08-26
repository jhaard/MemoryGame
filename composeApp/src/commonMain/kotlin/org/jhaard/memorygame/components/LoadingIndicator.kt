package org.jhaard.memorygame.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import memorygame.composeapp.generated.resources.Res
import memorygame.composeapp.generated.resources.diamond_shape_backside
import org.jetbrains.compose.resources.painterResource
import org.jhaard.memorygame.animations.spinningAnimation
import org.jhaard.memorygame.models.values.StringValues
import org.jhaard.memorygame.uiTheme.AppBorderSizing
import org.jhaard.memorygame.uiTheme.AppImageSizing
import org.jhaard.memorygame.uiTheme.AppShapes
import org.jhaard.memorygame.uiTheme.AppSpacing

/**
 * Custom Loading indicator with text.
 */
@Composable
fun LoadingIndicator() {

    val spinningAnimation =
        spinningAnimation(target = 360f, easing = LinearEasing, repeatMode = RepeatMode.Restart)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(Res.drawable.diamond_shape_backside),
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center,
            contentDescription = "Tile at start",
            modifier = Modifier
                .size(AppImageSizing.smallImageSize)
                .graphicsLayer {
                    rotationZ = spinningAnimation
                }
                .clip(AppShapes.small)
                .border(
                    color = MaterialTheme.colorScheme.tertiary,
                    width = AppBorderSizing.small,
                    shape = AppShapes.small
                )
        )

        Spacer(modifier = Modifier.padding(bottom = AppSpacing.small))

        Text(
            text = StringValues.LOADING_TEXT,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}