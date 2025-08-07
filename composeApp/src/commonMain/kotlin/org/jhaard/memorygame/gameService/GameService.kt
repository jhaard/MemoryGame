package org.jhaard.memorygame.gameService

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.jhaard.memorygame.localStorage.SettingsRepository
import org.jhaard.memorygame.models.TileData
import org.jhaard.memorygame.models.TileState


/**
 * GameService class.
 */
class GameService(private val localStorage: SettingsRepository) : ScoreManager, TimeManager {

    private val _score = MutableStateFlow(0)
    override val score: StateFlow<Int> = _score.asStateFlow()

    private val _timer = MutableStateFlow(0)
    override val timer: StateFlow<Int> = _timer.asStateFlow()

    private val _isRunning = MutableStateFlow(false)
    override val isRunning: StateFlow<Boolean> = _isRunning.asStateFlow()

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

    // region ScoreSystem implementation
    override fun updateScore(points: Int) {
        _score.value += points
    }

    override fun resetScore() {
        _score.value = 0
    }

    override fun startTimer(seconds: Int, scope: CoroutineScope) {

        scope.launch {
            _isRunning.value = true
            _timer.value = seconds

            do {
                delay(1000)
                _timer.value--
            } while (_timer.value > 0)

            _isRunning.value = false
        }

    }

    override fun stopTimer() {
        _isRunning.value = false
    }

    override fun updateTimer(seconds: Int) {
        _timer.value += seconds

    }
    // endregion

}