package org.jhaard.memorygame.models

data class TileData(
    val id: Int,
    val name: String,
    val tileState: TileState,
    val isContentVisible: Boolean
)
