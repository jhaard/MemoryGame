package org.jhaard.memorygame

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.jhaard.memorygame.components.TileComponent
import org.jhaard.memorygame.models.TileData
import org.jhaard.memorygame.models.TileState

@Composable
@Preview
fun App() {
    MaterialTheme {
        var currentState by remember { mutableStateOf(TileState.IDLE) }
        var isContentVisible by remember { mutableStateOf(false) }
        val tileData = TileData(
            id = 0,
            name = "{Image}",
            tileState = currentState,
            isContentVisible = isContentVisible
        )

        TileComponent(
            tile = tileData,
            onClick = {
                if (tileData.tileState == TileState.IDLE) {
                    currentState = TileState.FLIP
                    isContentVisible = true
                }
                if (tileData.tileState == TileState.FLIP) {
                    currentState = TileState.IDLE
                    isContentVisible = false

                }
            }
        )
    }
}