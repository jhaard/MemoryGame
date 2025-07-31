package org.jhaard.memorygame.models

import androidx.compose.ui.graphics.painter.BitmapPainter
import memorygame.composeapp.generated.resources.Res
import memorygame.composeapp.generated.resources.tile_backside
import org.jetbrains.compose.resources.Resource

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
