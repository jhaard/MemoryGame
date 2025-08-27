package org.jhaard.memorygame.screens.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import org.jhaard.memorygame.animations.moveAnimation
import org.jhaard.memorygame.animations.textAlphaAnimation
import org.jhaard.memorygame.components.TileBoard
import org.jhaard.memorygame.models.TileData
import org.jhaard.memorygame.uiTheme.AppSpacing

@Composable
fun PlayView(tileList: List<TileData>, timer: String, score: String, isAnimating: Boolean, onClick: (TileData) -> Unit) {
    val offsetYAnimation = moveAnimation(
        visible = isAnimating,
    )

    val textAlphaAnimation = textAlphaAnimation(visible = isAnimating)
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(AppSpacing.medium)
    ) {

        TileBoard(tileList = tileList, timer = timer, onClick = onClick)

        if (isAnimating) {
        Text(
            text = "+$score",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .graphicsLayer {
                    translationY = offsetYAnimation
                    alpha = textAlphaAnimation
                }
        )
            }

    }
}