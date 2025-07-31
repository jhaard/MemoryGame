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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import org.jhaard.memorygame.models.TileData
import org.jhaard.memorygame.models.TileState

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

    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Card(
            modifier = Modifier
                .size(100.dp)
                .padding(20.dp)
                .clickable(onClick = onClick, enabled = enabled)
                .graphicsLayer {
                    scaleX = scale
                    scaleY = scale
                },
            shape = RoundedCornerShape(10.dp),
            colors = CardColors(
                containerColor = if (tile.tileState == TileState.FLIP) Color.White else Color.Gray,
                contentColor = if (tile.tileState == TileState.FLIP) Color.White else Color.Gray,
                disabledContainerColor = Color.LightGray,
                disabledContentColor = Color.LightGray
            ),
            elevation = CardDefaults.cardElevation(7.dp),
            border = getBorder(tile.tileState)
        ) {
            TileContent(
                tile = tile
            )
        }
    }

}

fun getBorder(tileState: TileState): BorderStroke {
    return when (tileState) {
        TileState.IDLE -> BorderStroke(
            width = 4.dp,
            color = Color.White
        )

        TileState.FLIP -> BorderStroke(
            width = 4.dp,
            color = Color.Blue
        )

        TileState.MATCHED -> BorderStroke(
            width = 4.dp,
            color = Color.Green
        )
    }
}