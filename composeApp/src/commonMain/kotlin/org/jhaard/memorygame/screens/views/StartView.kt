package org.jhaard.memorygame.screens.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import memorygame.composeapp.generated.resources.Res
import memorygame.composeapp.generated.resources.tile_backside
import memorygame.composeapp.generated.resources.tile_pink
import org.jetbrains.compose.resources.painterResource
import org.jhaard.memorygame.components.GameButton
import org.jhaard.memorygame.uiTheme.AppBorderSizing
import org.jhaard.memorygame.uiTheme.AppImageSizing
import org.jhaard.memorygame.uiTheme.AppShapes
import org.jhaard.memorygame.uiTheme.ForegroundColor


@Composable
fun StartView(animations: Array<Float>, onPlay: () -> Unit, onHighScore: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .weight(1f)
        ) {

            Text(
                text = "MEMORY GAME",
                style = MaterialTheme.typography.displayLarge,
                modifier = Modifier
                    .graphicsLayer {
                        alpha = animations[0]
                    }
            )

            Image(
                painter = painterResource(Res.drawable.tile_backside),
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center,
                contentDescription = "Tile at start",
                modifier = Modifier
                    .size(AppImageSizing.largeImageSize)
                    .graphicsLayer {
                        rotationY = animations[1]
                        cameraDistance = 30f
                    }
                    .clip(shape = AppShapes.large)
                    .alpha(0.8f)
                    //.border(width = AppBorderSizing.small, color = MaterialTheme.colorScheme.secondary, shape = AppShapes.large)
            )

        }

        Column(
            verticalArrangement = Arrangement.SpaceEvenly, modifier = Modifier
                .weight(1f)
        ) {

            GameButton(
                buttonText = "PLAY",
                animate = true,
                onClick = onPlay
            )

            GameButton(
                buttonText = "HIGH SCORE",
                animate = false,
                onClick = onHighScore,
            )

        }
    }

}

