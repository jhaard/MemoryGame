package org.jhaard.memorygame.models

import org.jetbrains.compose.resources.DrawableResource

/**
 * Model of the tile data.
 */
data class TileData(
    val id: Int,
    val imageContent: DrawableResource,
    val backsideImage: DrawableResource,
    val tileState: TileState
)
