package org.jhaard.memorygame.models

import org.jetbrains.compose.resources.DrawableResource

/**
 * Model of the tile data.
 *
 * @property id The id of the tile in the list.
 * @property imageContent The image to pair.
 * @property backsideImage The default background image.
 * @property tileState The tile state.
 */
data class TileData(
    val id: Int,
    val imageContent: DrawableResource,
    val backsideImage: DrawableResource,
    val tileState: TileState
)
