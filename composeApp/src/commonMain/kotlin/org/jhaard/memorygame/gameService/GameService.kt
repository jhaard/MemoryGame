package org.jhaard.memorygame.gameService

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jhaard.memorygame.localStorage.SettingsRepository
import org.jhaard.memorygame.models.TileData
import org.jhaard.memorygame.models.TileState
import org.jhaard.memorygame.sound.AudioManager


/**
 * GameService class.
 */
class GameService(private val audioManager: AudioManager, private val localStorage: SettingsRepository) {

    // Initialize the tile list.
     fun initializeList(): List<TileData> {
        val listA = createTileList(0)
        val lastIndex = listA.lastIndex + 1
        val listB = createTileList(lastIndex)
        return listA + listB
    }

    /**
     * Creating the list of randomized tiles with the fetched image-urls.
     * @param startIndex The starting index if using multiple lists. (Test)
     */
    private fun createTileList(startIndex: Int): List<TileData> {
        val listOfTiles: MutableList<TileData> = mutableListOf()
        val listOfUrls = randomizedListOfTiles(imageList = getImageList())

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
     * @param timer The timer in seconds.
     */
    fun addScore(timer: Int): Int {
        return when (timer) {
            in 120 downTo 100 -> 20
            in 99 downTo 70 -> 12
            in 69 downTo 50 -> 10
            in 49 downTo 30 -> 8
            in 29 downTo 10 -> 5
            in 9 downTo 0 -> 2
            else -> 0
        }
    }

    fun playMatchingSound(scope: CoroutineScope) {
        scope.launch {
            audioManager.playSoundEffect(name = "match_edited")
        }
    }

    fun playErrorSound(scope: CoroutineScope) {
        scope.launch {
            audioManager.playSoundEffect(name = "error_edited")
            delay(200)
        }
    }

}