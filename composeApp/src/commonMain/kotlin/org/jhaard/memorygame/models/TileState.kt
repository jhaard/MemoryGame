package org.jhaard.memorygame.models

/**
 * The state of a tile.
 */
enum class TileState {
    // The idle state waiting to be flipped.
    IDLE,

    // The flipped state when picking a tile.
    FLIP,

    // The state when two tiles are matched.
    MATCHED
}