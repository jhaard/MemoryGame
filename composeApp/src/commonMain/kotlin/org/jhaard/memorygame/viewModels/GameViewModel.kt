package org.jhaard.memorygame.viewModels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.jhaard.memorygame.dummyData.TileListDummyData
import org.jhaard.memorygame.gameLogic.GameLogic
import org.jhaard.memorygame.models.TileData

class GameViewModel(private val gameLogic: GameLogic) : ViewModel() {

    private val _tileList = MutableStateFlow<List<TileData>>(emptyList())
    val tileList: StateFlow<List<TileData>> = _tileList

    init {
        _tileList.value = TileListDummyData.tileList
    }

    fun changeTileState(tile: TileData) {

    }
}