package org.jhaard.memorygame.viewModels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.jhaard.memorygame.gameLogic.GameLogic
import org.jhaard.memorygame.localStorage.SettingsRepository
import org.jhaard.memorygame.models.TileData
import org.jhaard.memorygame.models.TileState


/**
 * The viewmodel for the game.
 *
 * @param gameLogic Inserting a GameLogic-klass to separate some core logic.
 * @param localStorage Getting saved data, for example image-url's.
 */
class GameViewModel(
    private val gameLogic: GameLogic,
    private val localStorage: SettingsRepository
) :
    ViewModel() {

    private val _tileList = MutableStateFlow<List<TileData>>(emptyList())
    val tileList: StateFlow<List<TileData>> = _tileList

    init {
        val listA = createTileList(0)
        val lastIndex = listA.lastIndex + 1
        val listB = createTileList(lastIndex)

        _tileList.value = listA + listB
    }

    /**
     * Changing the state of a tile based on id.
     * @param id The tile id.
     */
    fun changeTileState(id: Int) {
        _tileList.value = _tileList.value.map { tile ->
            if (tile.id == id && !checkTileState(tile))
                tile.copy(tileState = TileState.FLIP)
            else if (tile.id == id && checkTileState(tile))
                tile.copy(tileState = TileState.IDLE)
            else tile
        }
    }

    /**
     * Create a tile list starting at a given start index.
     * @param startIndex The index to start with.
     * @return A list of tiles.
     */
    private fun createTileList(startIndex: Int): List<TileData> {
        val listOfTiles: MutableList<TileData> = mutableListOf()
        val listOfUrls = getImageList()

        if (listOfUrls.isNotEmpty()) {
            listOfUrls.forEachIndexed { index, url ->
                listOfTiles.add(
                    TileData(
                        id = startIndex + index,
                        imageContent = url,
                        TileState.IDLE
                    )
                )
            }
        }
        return listOfTiles
    }

    /**
     * Checking if the tile is flipped.
     * @param tile The tile to check.
     */
    private fun checkTileState(tile: TileData): Boolean {
        return tile.tileState == TileState.FLIP
    }

    /**
     * Fetch the locally saved image urls.
     * @return The list of url strings.
     */
    private fun getImageList(): List<String> {
        return localStorage.getUrlList()
    }

}