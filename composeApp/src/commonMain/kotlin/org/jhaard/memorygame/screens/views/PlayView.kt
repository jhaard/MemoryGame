package org.jhaard.memorygame.screens.views

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import org.jhaard.memorygame.animations.moveAnimation
import org.jhaard.memorygame.animations.textAlphaAnimation
import org.jhaard.memorygame.components.TileBoard
import org.jhaard.memorygame.models.TileData
import org.jhaard.memorygame.uiTheme.AppSpacing

@Composable
fun PlayView(
    tileList: List<TileData>,
    timer: String,
    score: String,
    isAnimating: Boolean,
    onClick: (TileData) -> Unit
) {

    var clickOffset by remember { mutableStateOf(Offset.Zero) }
    // var size by remember { mutableStateOf(IntSize.Zero) }


    val offsetYAnimation = moveAnimation(
        startY = clickOffset.y,
        visible = isAnimating,
    )

    val textAlphaAnimation = textAlphaAnimation(visible = isAnimating)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(AppSpacing.medium)
    ) {

        TileBoard(
            tileList = tileList,
            timer = timer,
            onClick = onClick,
            onCoordinatesClicked = { offset ->
                println(offset)
                clickOffset = offset
            })

        if (isAnimating) {
            Text(
                text = "+$score",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier
//                    .onGloballyPositioned { layoutCoordinates ->
//                        size = layoutCoordinates.size
//                    }
                    .graphicsLayer {
                        translationX = clickOffset.x
                        translationY = clickOffset.y

                    }
                    .border(width = 4.dp, color = Color.Black, shape = RectangleShape)
            )

        }


    }
}