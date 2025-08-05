package org.jhaard.memorygame.gameService

import org.jhaard.memorygame.localStorage.SettingsRepository
import org.jhaard.memorygame.models.TileData
import org.jhaard.memorygame.models.TileState


/**
 * GameService class.
 */
class GameService(private val localStorage: SettingsRepository) {

    /**
     * Creating the list of randomized tiles with the fetched image-urls.
     * @param startIndex The starting index if using multiple lists. (Test)
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

    /**
     * Randomized order of image-urls.
     * @return The shuffled list of url strings.
     */
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

}
