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
        TileData(0, painterContent, painterBackside, TileState.IDLE),
        TileData(1, painterContent, painterBackside, TileState.IDLE),
        TileData(2, painterContent, painterBackside, TileState.IDLE),
        TileData(3, painterContent, painterBackside, TileState.IDLE),
        TileData(4, painterContent, painterBackside, TileState.IDLE),
        TileData(5, painterContent, painterBackside, TileState.IDLE),
        TileData(6, painterContent, painterBackside, TileState.IDLE),
        TileData(7, painterContent, painterBackside, TileState.IDLE),
        TileData(8, painterContent, painterBackside, TileState.IDLE),
        TileData(9, painterContent, painterBackside, TileState.IDLE),
        TileData(10, painterContent, painterBackside, TileState.IDLE),
        TileData(11, painterContent, painterBackside, TileState.IDLE),
        TileData(12, painterContent, painterBackside, TileState.IDLE),
        TileData(13, painterContent, painterBackside, TileState.IDLE),
        TileData(14, painterContent, painterBackside, TileState.IDLE),
        TileData(15, painterContent, painterBackside, TileState.IDLE),
        TileData(16, painterContent, painterBackside, TileState.IDLE),
        TileData(17, painterContent, painterBackside, TileState.IDLE),
        TileData(18, painterContent, painterBackside, TileState.IDLE),
        TileData(19, painterContent, painterBackside, TileState.IDLE),
        TileData(20, painterContent, painterBackside, TileState.IDLE),
        TileData(21, painterContent, painterBackside, TileState.IDLE),
        TileData(22, painterContent, painterBackside, TileState.IDLE),
        TileData(23, painterContent, painterBackside, TileState.IDLE),
        TileData(24, painterContent, painterBackside, TileState.IDLE),
        TileData(25, painterContent, painterBackside, TileState.IDLE),
        TileData(26, painterContent, painterBackside, TileState.IDLE),
        TileData(27, painterContent, painterBackside, TileState.IDLE)
    )

}
