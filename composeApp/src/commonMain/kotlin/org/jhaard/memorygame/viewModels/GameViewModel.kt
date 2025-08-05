package org.jhaard.memorygame.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.jhaard.memorygame.gameLogic.GameLogic
import org.jhaard.memorygame.models.TileData
import org.jhaard.memorygame.models.TileState


/**
 * The viewmodel for the game.
 *
 * @param gameLogic Inserting a GameLogic-klass to separate some core logic.
 */
class GameViewModel(
    private val gameLogic: GameLogic
) : ViewModel() {

    private val _tileList = MutableStateFlow<List<TileData>>(emptyList())
    val tileList: StateFlow<List<TileData>> = _tileList

    init {
        viewModelScope.launch {
            val listA = gameLogic.createTileList(0)
            val lastIndex = listA.lastIndex + 1
            val listB = gameLogic.createTileList(lastIndex)

            _tileList.value = listA + listB
        }
    }

    fun runGameFlow(id: Int, url: String) {
        updateTileList(
            predicate = {it.tileState == TileState.IDLE && it.id == id },
            transform = { it.copy(tileState = TileState.FLIP) }
        )
        setStateIfMatched(url = url)
        checkIfMaximumTilesAreFlipped()
    }

    private fun updateTileList(
        predicate: (TileData) -> Boolean,
        transform: (TileData) -> TileData
    ) {
        _tileList.value = _tileList.value.map { tile ->
            if (predicate(tile)) transform(tile) else tile
        }
    }

    private fun onMatched(url: String): Boolean {
        val newList = getCurrentlyFlippedTiles(_tileList.value)
        val values = newList.map { it.imageContent }
        return values.all { it == url } && values.size > 1
    }

    private fun setStateIfMatched(url: String) {
        if (onMatched(url)) {
            updateTileList(
                predicate = {it.tileState == TileState.FLIP},
                transform = {it.copy(tileState = TileState.MATCHED)}
            )
        }
    }

    private fun checkIfMaximumTilesAreFlipped() {
        val newList = getCurrentlyFlippedTiles(_tileList.value)
        if (newList.size > 1) {
            viewModelScope.launch {
                delay(500)
                updateTileList(
                    predicate = { it.tileState == TileState.FLIP },
                    transform = { it.copy(tileState = TileState.IDLE) }
                )
            }
        }
    }

    private fun getCurrentlyFlippedTiles(tileList: List<TileData>): List<TileData> {
        return tileList.filter { it.tileState == TileState.FLIP }
    }

}