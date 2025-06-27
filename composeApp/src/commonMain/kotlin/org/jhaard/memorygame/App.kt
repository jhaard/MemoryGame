package org.jhaard.memorygame

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import memorygame.composeapp.generated.resources.Res
import memorygame.composeapp.generated.resources.compose_multiplatform
import memorygame.composeapp.generated.resources.tile_backside
import org.jetbrains.compose.resources.painterResource
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
        val painterContent = painterResource(resource = Res.drawable.compose_multiplatform)
        val painterBackside = painterResource(resource = Res.drawable.tile_backside)
        val tileData = TileData(
            id = 0,
            imageContent = painterContent,
            backsideImage = painterBackside,
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