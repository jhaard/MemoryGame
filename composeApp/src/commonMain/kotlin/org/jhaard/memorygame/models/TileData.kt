package org.jhaard.memorygame.models

/**
 * Model of the tile data.
 *
 * @property id The id of the tile in the list.
 * @property imageContent The image to pair.
 * @property tileState The tile state.
 */
data class TileData(
    val id: Int,
    val imageContent: String,
    val tileState: TileState
)
