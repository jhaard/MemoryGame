package org.jhaard.memorygame.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.jhaard.memorygame.gameService.GameService
import org.jhaard.memorygame.models.TileData
import org.jhaard.memorygame.models.TileState


/**
 * The viewmodel for the game.
 *
 * @param gameService Inserting a GameService-klass to separate some functions
 * where UI is not involved.
 */
class GameViewModel(
    private val gameService: GameService
) : ViewModel() {

    // The UI tile list.
    private val _tileList = MutableStateFlow<List<TileData>>(emptyList())
    val tileList: StateFlow<List<TileData>> = _tileList

    init {
        val listA = gameService.createTileList(0)
        val lastIndex = listA.lastIndex + 1
        val listB = gameService.createTileList(lastIndex)

        _tileList.value = listA + listB
    }

    /**
     * The public game flow function of clicks and states.
     * @param tileId The id of the clicked tile.
     * @param imageUrl The image url of the clicked tile.
     * @param clickCount Counter of clicks.
     */
    fun runGameFlow(tileId: Int, imageUrl: String, clickCount: Int) {
        updateTileList(
            predicate = { it.tileState == TileState.IDLE && it.id == tileId },
            transform = { it.copy(tileState = TileState.FLIP) }
        )
        setStateIfMatched(url = imageUrl)
        checkIfMaximumTilesAreFlipped(clickCount = clickCount)
    }

    /**
     * The function to update the tile list.
     * @param predicate The predicate to evaluate.
     * @param transform The tile to be replaced with different state.
     */
    private fun updateTileList(
        predicate: (TileData) -> Boolean,
        transform: (TileData) -> TileData
    ) {
        _tileList.value = _tileList.value.map { tile ->
            if (predicate(tile)) transform(tile) else tile
        }
    }

    /**
     * Checks if the image content urls are identical.
     * @param url The image url.
     * @return Returns true if both flipped tiles have the same urls.
     */
    private fun onMatched(url: String): Boolean {
        val newList = _tileList.value.filter { it.tileState == TileState.FLIP }
        val values = newList.map { it.imageContent }
        return values.all { it == url } && values.size > 1
    }

    /**
     * Sets matched state if matched.
     * @param url The image url to check.
     */
    private fun setStateIfMatched(url: String) {
        if (onMatched(url)) {
            updateTileList(
                predicate = { it.tileState == TileState.FLIP },
                transform = { it.copy(tileState = TileState.MATCHED) }
            )
        }
    }

    /**
     * Counting clicks to determine if two tiles are flipped.
     * @param clickCount The click counter.
     */
    private fun checkIfMaximumTilesAreFlipped(clickCount: Int) {
        if (clickCount == 2) {
            viewModelScope.launch {
                delay(500)
                updateTileList(
                    predicate = { it.tileState == TileState.FLIP },
                    transform = { it.copy(tileState = TileState.IDLE) }
                )
            }
        }
    }

}