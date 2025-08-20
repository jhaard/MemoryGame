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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import memorygame.composeapp.generated.resources.Res
import memorygame.composeapp.generated.resources.diamond_shape_backside
import memorygame.composeapp.generated.resources.neon_backside
import org.jetbrains.compose.resources.painterResource
import org.jhaard.memorygame.animations.spinningAnimation

/**
 * Custom Loading indicator with text.
 */
@Composable
fun LoadingIndicator() {
    val mintGreen = Color(0xFF73F4A7)
    val skyBlue = Color(0xFF5FD0EA)

    val spinning = spinningAnimation(target = 360f, easing = LinearEasing, repeatMode = RepeatMode.Restart)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(Res.drawable.neon_backside),
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center,
            contentDescription = "Tile at start",
            modifier = Modifier
                .size(width = 50.dp, height = 50.dp)
                .graphicsLayer {
                    rotationZ = spinning
                }
                .clip(shape = RoundedCornerShape(5.dp))
                .border(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            mintGreen,
                            skyBlue
                        ),
                    ),
                    width = 2.dp,
                    shape = RoundedCornerShape(size = 5.dp)
                )
        )
        Spacer(modifier = Modifier.padding(bottom = 10.dp))
        Text(
            text = "Activating service...\nThis might take up to 50 seconds.\n(Only the first time starting the app)",
            fontSize = 18.sp,
            color = Color.Green,
            textAlign = TextAlign.Center,
            style = TextStyle(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        mintGreen,
                        skyBlue
                    )
                )
            )
        )
    }
}