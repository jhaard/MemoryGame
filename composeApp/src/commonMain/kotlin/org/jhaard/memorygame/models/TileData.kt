package org.jhaard.memorygame.models

import androidx.compose.ui.graphics.painter.Painter

/**
 * Model of the tile data.
 */
data class TileData(
    val id: Int,
    val imageContent: Painter,
    val backsideImage: Painter,
    val tileState: TileState,
    val isContentVisible: Boolean
)
