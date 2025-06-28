package org.jhaard.memorygame

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.jhaard.memorygame.components.GameBoard
import org.jhaard.memorygame.dummyData.TileListDummyData

@Composable
@Preview
fun App() {

    MaterialTheme {

        GameBoard(tiles = TileListDummyData.tileList)

    }

}