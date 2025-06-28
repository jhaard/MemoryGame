package org.jhaard.memorygame.dummyData

import memorygame.composeapp.generated.resources.Res
import memorygame.composeapp.generated.resources.compose_multiplatform
import memorygame.composeapp.generated.resources.tile_backside
import org.jhaard.memorygame.models.TileData
import org.jhaard.memorygame.models.TileState


object TileListDummyData {
    private val painterContent = Res.drawable.compose_multiplatform
    private val painterBackside = Res.drawable.tile_backside

    val tileList = listOf(
        TileData(0, painterContent, painterBackside, TileState.IDLE, false),
        TileData(1, painterContent, painterBackside, TileState.IDLE, false),
        TileData(2, painterContent, painterBackside, TileState.IDLE, false),
        TileData(3, painterContent, painterBackside, TileState.IDLE, false),
        TileData(4, painterContent, painterBackside, TileState.IDLE, false),
        TileData(5, painterContent, painterBackside, TileState.IDLE, false),
        TileData(6, painterContent, painterBackside, TileState.IDLE, false),
        TileData(7, painterContent, painterBackside, TileState.IDLE, false),
        TileData(8, painterContent, painterBackside, TileState.IDLE, false),
        TileData(9, painterContent, painterBackside, TileState.IDLE, false),
        TileData(10, painterContent, painterBackside, TileState.IDLE, false),
        TileData(11, painterContent, painterBackside, TileState.IDLE, false),
        TileData(12, painterContent, painterBackside, TileState.IDLE, false),
        TileData(13, painterContent, painterBackside, TileState.IDLE, false),
        TileData(14, painterContent, painterBackside, TileState.IDLE, false)
    )

}
