package org.jhaard.memorygame.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.jhaard.memorygame.services.GameService
import org.jhaard.memorygame.models.GameState
import org.jhaard.memorygame.models.TileData
import org.jhaard.memorygame.models.TileState
import org.jhaard.memorygame.services.AudioService
import org.jhaard.memorygame.services.TimerService
import org.jhaard.memorygame.utils.updateState
import org.jhaard.memorygame.utils.updateTileList

/**
 * The viewmodel for the GameScreen.
 *
 * @param gameService Inserting a GameService class to separate some logic functions.
 * @param audioService The AudioService to play sounds.
 * @param timerService Manages the timer.
 * where UI is not involved.
 */
class GameViewModel(
    key: String,
    private val gameService: GameService,
    private val audioService: AudioService,
    private val timerService: TimerService
) : ViewModel() {

    // The state of the game
    private val _uiState = MutableStateFlow<GameState>(GameState.Initial)
    val uiState: StateFlow<GameState> = _uiState.asStateFlow()

    // The UI tile list.
    private val _tileList = MutableStateFlow<List<TileData>>(emptyList())
    val tileList: StateFlow<List<TileData>> = _tileList

    init {
        startGame(key = key)
    }

     private fun startGame(key: String) {
        _tileList.value = gameService.initializeList(key = key)
        val startTime = 120

        _uiState.updateState<GameState.Initial> {
            GameState.Playing(
                timer = startTime,
                score = 0,
                clickCount = 0
            )
        }
        updateTime(startTime = startTime)
    }

    fun resetGame(key: String) {
        _uiState.updateState<GameState.GameOver> { GameState.Initial }
        startGame(key = key)
    }

    // Update the timer and set it to the game state.
    private fun updateTime(startTime: Int) {
        timerService.startTimer(
            startTime = startTime,
            scope = viewModelScope,
            onTick = { timeLeft ->
                _uiState.updateState<GameState.Playing> { playing -> playing.copy(timer = timeLeft) }
            },
            onComplete = {
                _uiState.updateState<GameState.Playing> { GameState.GameOver(score = it.score) }
            }
        )
    }

    /**
     * This is the main play function - flip the tile, update the clickCount and run checks.
     * @param tileId The id of the clicked tile.
     * @param imageUrl The image url of the clicked tile.
     */
    fun flipTile(tileId: Int, imageUrl: String) {
        _uiState.updateState<GameState.Playing> {
            it.copy(clickCount = it.clickCount + 1)
        }
        _tileList.value = _tileList.value.updateTileList(
            predicate = { it.tileState == TileState.IDLE && it.id == tileId },
            transform = { it.copy(tileState = TileState.FLIP) }
        )
        runChecks(imageUrl = imageUrl)
    }

    /**
     * Run the checks when flipping tiles.
     * @param imageUrl The image url of the tile to check.
     */
    private fun runChecks(imageUrl: String) {
        checkMaximumOpenTiles(imageUrl = imageUrl)
        setConditionsWhenMatched(imageUrl = imageUrl)
    }

    /**
     * If tiles are matched, update the state with score and the tile-list.
     * @param imageUrl The image url to check.
     */
    private fun setConditionsWhenMatched(imageUrl: String) {
        if (gameService.isMatched(tileList = _tileList.value, imageUrl = imageUrl)) {
            audioService.playMatchingSound(scope = viewModelScope)
            _uiState.updateState<GameState.Playing> {
                it.copy(
                    clickCount = 0,
                    score = it.score + gameService.addScore(whereTimerIs = it.timer)
                )
            }
            _tileList.value = _tileList.value.updateTileList(
                predicate = { it.tileState == TileState.FLIP },
                transform = { it.copy(tileState = TileState.MATCHED) }
            )
            isTileBoardComplete()
        }
    }

    /**
     * Checks for open tiles. Reset clickCount and change back the tiles to IDLE state.
     * @param imageUrl The image url to check.
     */
    private fun checkMaximumOpenTiles(imageUrl: String) {
        if (gameService.maximumClicks(currentState = _uiState.value) && !gameService.isMatched(
                imageUrl = imageUrl,
                tileList = _tileList.value
            )
        ) {
            _uiState.updateState<GameState.Playing> { it.copy(clickCount = 0) }

            viewModelScope.launch {
                audioService.playErrorSound(scope = this)
                delay(200)
                _tileList.value = _tileList.value.updateTileList(
                    predicate = { it.tileState == TileState.FLIP },
                    transform = { it.copy(tileState = TileState.IDLE) }
                )
            }
        }
    }

    // When every pair are matched, change the GameState.
    private fun isTileBoardComplete() {
        if (_tileList.value.all { it.tileState == TileState.MATCHED }) {
            _uiState.updateState<GameState.Playing> { playState ->
                timerService.stopTimer()
                GameState.GameOver(score = playState.score)
            }
        }
    }

}