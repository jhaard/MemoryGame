package org.jhaard.memorygame.gameLogic

import org.jhaard.memorygame.localStorage.SettingsRepository
import org.jhaard.memorygame.models.TileData
import org.jhaard.memorygame.models.TileState


/**
 * GameLogic class.
 */
class GameLogic(private val localStorage: SettingsRepository){

    /**
     * Changing the state of a tile based on id.
     * @param id The tile id.
     */
    fun createTileList(startIndex: Int): List<TileData> {
        val listOfTiles: MutableList<TileData> = mutableListOf()
        val listOfUrls = randomizedListOfTiles(imageList = getImageList())

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

    private fun randomizedListOfTiles(imageList: List<String>): List<String> {
        return imageList.shuffled()

    }


    /**
     * Fetch the locally saved image urls.
     * @return The list of url strings.
     */
    private fun getImageList(): List<String> {
        return localStorage.getUrlList()
    }

    /**
     * Checking if the tile is flipped.
     * @param tile The tile to check.
     */
    fun checkTileState(tile: TileData): Boolean {
        return tile.tileState == TileState.FLIP
    }

}
