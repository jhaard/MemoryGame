package org.jhaard.memorygame.utils

import org.jhaard.memorygame.models.GameState
import org.jhaard.memorygame.models.TileData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

/**
 * The function to update the tile list.
 * @param predicate The predicate to evaluate.
 * @param transform The tile to be replaced with different state.
 */
fun List<TileData>.updateTileList(
    predicate: (TileData) -> Boolean,
    transform: (TileData) -> TileData
): List<TileData> {
    return map { tile ->
        if (predicate(tile)) transform(tile) else tile
    }
}

/**
 * Function to update the GameState and it's properties.
 * @param transform to desired GameState or update the current.
 */
inline fun <reified T : GameState> MutableStateFlow<GameState>.updateState(
    transform: (T) -> GameState
) {
    update { current ->
        if (current is T) transform(current) else current
    }
}