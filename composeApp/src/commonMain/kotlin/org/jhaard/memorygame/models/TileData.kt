package org.jhaard.memorygame.models

/**
 * Model of the tile data.
 */
data class TileData(
    val id: Int,
    val name: String,
    val tileState: TileState,
    val isContentVisible: Boolean
)
