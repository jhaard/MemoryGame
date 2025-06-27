package org.jhaard.memorygame.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

/**
 * The content to be paired.
 * TODO change content
 * @param text currently a string during gameplay development, but should display image content.
 * @param showContent showing the content after a slight delay of the animation.
 */
@Composable
fun TileContent(text: String, showContent: Boolean) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .graphicsLayer {
                rotationY = 180f
            }
    ) {
        Text(
            text = if (showContent) text else "",
            color = Color.Black,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
        )
    }
}