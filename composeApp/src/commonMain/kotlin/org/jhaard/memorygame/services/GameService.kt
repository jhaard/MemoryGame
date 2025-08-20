package org.jhaard.memorygame.services

import org.jhaard.memorygame.localStorage.SettingsRepository
import org.jhaard.memorygame.models.TileData
import org.jhaard.memorygame.models.TileState


/**
 * GameService class.
 */
class GameService(private val localStorage: SettingsRepository) {

    // Initialize the tile list.
     fun initializeList(key: String): List<TileData> {
        val listA = createTileList(key = key, startIndex = 0)
        val lastIndex = listA.lastIndex + 1
        val listB = createTileList(key = key, startIndex = lastIndex)
        val combinedList = listA + listB
        return randomizedListOfTiles(tileList = combinedList)
    }

    /**
     * Creating the list of randomized tiles with the fetched image-urls.
     * @param startIndex The starting index if using multiple lists. (Test)
     */
    private fun createTileList(key: String, startIndex: Int): List<TileData> {
        val listOfTiles: MutableList<TileData> = mutableListOf()
        val listOfUrls = getImageList(key = key)

        if (listOfUrls.isNotEmpty()) {
            listOfUrls.forEachIndexed { index, url ->
                listOfTiles.add(
                    TileData(
                        id = startIndex + index,
                        imageContent = url,
                        tileState = TileState.IDLE
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
    private fun randomizedListOfTiles(tileList: List<TileData>): List<TileData> {
        return tileList.shuffled()
    }

    /**
     * Fetch the locally saved image urls.
     * @return The list of url strings.
     */
    private fun getImageList(key: String): List<String> {
        return localStorage.getUrlList(key = key)
    }

    /**
     * Checks if the image content urls are identical.
     * @param imageUrl The image url to check.
     * @return Returns true if both flipped tiles have the same urls.
     */
     fun isMatched(tileList: List<TileData>, imageUrl: String): Boolean {
        val flippedList = tileList.filter { it.tileState == TileState.FLIP }
        val values = flippedList.map { it.imageContent }
        return values.all { it == imageUrl } && values.size > 1
    }

    /**
     * Adds score depending on what the timer currently is.
     * @param whereTimerIs The timer in seconds.
     * @return The score.
     */
    fun addScore(whereTimerIs: Int): Int {
        return when (whereTimerIs) {
            in 120 downTo 100 -> 20
            in 99 downTo 70 -> 12
            in 69 downTo 50 -> 10
            in 49 downTo 30 -> 8
            in 29 downTo 10 -> 5
            in 9 downTo 0 -> 2
            else -> 0
        }
    }

}