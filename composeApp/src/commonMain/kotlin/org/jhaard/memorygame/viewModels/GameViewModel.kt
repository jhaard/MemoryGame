package org.jhaard.memorygame.viewModels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.jhaard.memorygame.dummyData.TileListDummyData
import org.jhaard.memorygame.gameLogic.GameLogic
import org.jhaard.memorygame.models.TileData
import org.jhaard.memorygame.models.TileState

/**
 * The viewmodel for the game.
 *
 * @param gameLogic Inserting a GameLogic-klass to separate some core logic to keep files smaller.
 */
class GameViewModel(private val gameLogic: GameLogic) : ViewModel() {

    private val _tileList = MutableStateFlow<List<TileData>>(emptyList())
    val tileList: StateFlow<List<TileData>> = _tileList

    init {
        _tileList.value = TileListDummyData.tileList
    }

    fun changeTileState(id: Int) {
        _tileList.value = _tileList.value.map { tile ->
            if (tile.id == id && !checkTileState(tile))
                tile.copy(tileState = TileState.FLIP)
            else if (tile.id == id && checkTileState(tile))
                tile.copy(tileState = TileState.IDLE)
            else tile
        }
    }

    private fun checkTileState(tile: TileData): Boolean {
        return tile.tileState == TileState.FLIP

    }

}