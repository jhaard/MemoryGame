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
 * The viewmodel for the GameScreen.
 *
 * @param gameService Inserting a GameService class to separate some functions
 * where UI is not involved.
 */
class GameViewModel(
    private val gameService: GameService
) : ViewModel() {

    // Score and Timer
    val score = gameService.score
    val timer = gameService.timer
    val isRunning = gameService.isRunning

    // The UI tile list.
    private val _tileList = MutableStateFlow<List<TileData>>(emptyList())
    val tileList: StateFlow<List<TileData>> = _tileList

    init {
        val listA = gameService.createTileList(0)
        val lastIndex = listA.lastIndex + 1
        val listB = gameService.createTileList(lastIndex)

        _tileList.value = listA + listB

        resetScore()
        startTimer()
    }

    /**
     * The public game flow function of clicks and states.
     * @param tileId The id of the clicked tile.
     * @param imageUrl The image url of the clicked tile.
     */
    fun runGameFlow(tileId: Int, imageUrl: String) {
        updateTileList(
            predicate = { it.tileState == TileState.IDLE && it.id == tileId },
            transform = { it.copy(tileState = TileState.FLIP) }
        )
        setConditionsWhenMatched(imageUrl = imageUrl)
        checkIfMaximumTilesAreFlipped()
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
     * @param imageUrl The image url to check.
     * @return Returns true if both flipped tiles have the same urls.
     */
    private fun isMatched(imageUrl: String): Boolean {
        val newList = _tileList.value.filter { it.tileState == TileState.FLIP }
        val values = newList.map { it.imageContent }
        return values.all { it == imageUrl } && values.size > 1
    }

    /**
     * If tiles are matched, update the state, timer and score.
     * @param imageUrl The image url to check.
     */
    private fun setConditionsWhenMatched(imageUrl: String) {
        if (isMatched(imageUrl = imageUrl)) {
            updateTileList(
                predicate = { it.tileState == TileState.FLIP },
                transform = { it.copy(tileState = TileState.MATCHED) }
            )
            updateScore()
            checkIfAllTilesAreFlipped()
        }
    }

    /**
     * Filter tiles that are flipped and if they are greater than 2, update the tiles.
     * Changed back to this since the application only have small lists.
     */
    private fun checkIfMaximumTilesAreFlipped() {
        val newList = _tileList.value.filter { it.tileState == TileState.FLIP }
        if (newList.size == 2) {
            viewModelScope.launch {
                delay(200)
                updateTileList(
                    predicate = { it.tileState == TileState.FLIP },
                    transform = { it.copy(tileState = TileState.IDLE) }
                )
            }
        }
    }

    private fun checkIfAllTilesAreFlipped() {
        if (_tileList.value.all { it.tileState == TileState.MATCHED }) {
            gameService.stopGame()
        }
    }

    private fun startTimer() {
        gameService.startTimer(120, viewModelScope)
    }

    private fun updateScore() {
        gameService.updateScore()
    }

    private fun resetScore() {
        gameService.resetScore()
    }

}