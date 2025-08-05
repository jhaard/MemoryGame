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
        flipTile(id = id)
        setStateIfMatched(url = url)

        if (onMaximumFlippedTiles()) {
            viewModelScope.launch {
                delay(500)
                _tileList.value = _tileList.value.map { tile ->
                    if (tile.tileState == TileState.FLIP) {
                        tile.copy(tileState = TileState.IDLE)
                    } else {
                        tile
                    }
                }
            }
        }
    }

    private fun flipTile(id: Int) {
        _tileList.value = _tileList.value.map { tile ->
            if (tile.id == id && !gameLogic.checkTileState(tile))
                tile.copy(tileState = TileState.FLIP)
            else tile
        }
    }

    private fun onMatched(url: String): Boolean {
        val newList = filterFlippedTiles(_tileList.value)
        val values = newList.map { it.imageContent }
        return values.all { it == url } && values.size > 1
    }

    private fun setStateIfMatched(url: String) {
        if (onMatched(url)) {
            _tileList.value = _tileList.value.map { tile ->
                if (tile.imageContent == url) {
                    tile.copy(tileState = TileState.MATCHED)
                } else {
                    tile
                }
            }
        }
    }

    private fun onMaximumFlippedTiles(): Boolean {
        val newList = filterFlippedTiles(_tileList.value)
        return newList.size > 1
    }

    private fun filterFlippedTiles(tileList: List<TileData>): List<TileData> {
        return tileList.filter { it.tileState == TileState.FLIP }
    }

}