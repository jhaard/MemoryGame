package org.jhaard.memorygame.components

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import org.jhaard.memorygame.models.TileData
import org.jhaard.memorygame.models.TileState

/**
 * A Memory Tile Component
 * @param tile The data of the tile.
 * @param onClick The click event of the tile.
 */
@Composable
fun TileComponent(
    tile: TileData,
    onClick: () -> Unit,
) {
    val transition = updateTransition(tile.tileState, label = "transition")

    val rotate by transition.animateFloat(
        transitionSpec = {
            tween(500)
        },
        label = "rotate"
    ) { state ->
        when (state) {
            TileState.IDLE -> 0f
            TileState.FLIP -> 180f
        }
    }

    var showContent by remember { mutableStateOf(false) }

    LaunchedEffect(tile.isContentVisible) {
        withContext(Dispatchers.IO) {
            delay(200)
            showContent = tile.isContentVisible
        }
    }

    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Card(
            modifier = Modifier
                .size(120.dp)
                .padding(20.dp)
                .clickable(onClick = onClick)
                .graphicsLayer {
                    rotationY = rotate
                },
            shape = RoundedCornerShape(10.dp),
            colors = CardColors(
                containerColor = if (showContent) Color.White else Color.Gray,
                contentColor = if (showContent) Color.White else Color.Gray,
                disabledContainerColor = Color.Gray,
                disabledContentColor = Color.LightGray
            ),
            elevation = CardDefaults.cardElevation(7.dp),
            border = if (showContent) BorderStroke(4.dp, Color.Blue) else BorderStroke(
                4.dp,
                Color.Gray
            )
        ) {
            TileContent(imageContent = tile.imageContent, backsideImage = tile.backsideImage, showContent = showContent)
        }
    }
}