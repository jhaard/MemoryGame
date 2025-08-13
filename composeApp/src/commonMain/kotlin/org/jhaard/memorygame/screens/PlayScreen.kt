package org.jhaard.memorygame.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.jhaard.memorygame.components.TileBoard
import org.jhaard.memorygame.models.TileData

@Composable
fun PlayScreen(tileList: List<TileData>, timer: String, onClick: (TileData) -> Unit) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF232323))
    ) {

        TileBoard(tileList = tileList, timer = timer, onClick = onClick)
//            clickCount++
//
//            gameViewModel.runGameFlow(
//                tileId = tile.id,
//                imageUrl = tile.imageContent,
//                clickCount = clickCount
//            )
//
//            if (clickCount == 2) {
//                clickCount = 0
//            }




    }
}