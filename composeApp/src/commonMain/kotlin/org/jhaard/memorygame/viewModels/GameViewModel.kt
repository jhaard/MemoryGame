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


/**
 * The viewmodel for the GameScreen.
 *
 * @param gameService Inserting a GameService class to separate some functions
 * where UI is not involved.
 */
class GameViewModel(
    private val gameService: GameService,
    private val audioService: AudioService
) : ViewModel() {

    // The state of the game
    private val _uiState = MutableStateFlow<GameState>(GameState.Initial)
    val uiState: StateFlow<GameState> = _uiState.asStateFlow()

    // The UI tile list.
    private val _tileList = MutableStateFlow<List<TileData>>(emptyList())
    val tileList: StateFlow<List<TileData>> = _tileList

    init {
        if (_uiState.value !is GameState.Playing) {
            startGame()
        }
    }

    private fun startGame() {
        _tileList.value = gameService.initializeList()

        updateState<GameState.Initial> {
            GameState.Playing(
                timer = 120,
                score = 0,
                clickCount = 0
            )
        }
        updateTime(timeLeft = (_uiState.value as GameState.Playing).timer)
    }

    fun resetGame() {
        updateState<GameState.GameOver> { GameState.Initial }
        startGame()
    }

    private fun updateTime(timeLeft: Int) {
        viewModelScope.launch {
            repeat(timeLeft) {
                delay(1000)
                updateState<GameState.Playing> { it.copy(timer = it.timer - 1) }
            }
            updateState<GameState.Playing> { playState ->
                GameState.GameOver(score = playState.score)
            }
        }
    }

    /**
     * The public game flow function of clicks and states.
     * @param tileId The id of the clicked tile.
     * @param imageUrl The image url of the clicked tile.
     */
    fun flipTile(tileId: Int, imageUrl: String) {
        updateState<GameState.Playing> {
            it.copy(clickCount = it.clickCount + 1)
        }
        updateTileList(
            predicate = { it.tileState == TileState.IDLE && it.id == tileId },
            transform = { it.copy(tileState = TileState.FLIP) }
        )

        runChecks(imageUrl = imageUrl)

    }

    private fun runChecks(imageUrl: String) {
        checkMaximumOpenTiles(imageUrl = imageUrl)
        setConditionsWhenMatched(imageUrl = imageUrl)
    }

    /**
     * The function to update the tile list.
     * @param predicate The predicate to evaluate.
     * @param transform The tile to be replaced with different state.
     */
    private fun updateTileList(
        predicate: (TileData) -> Boolean,
        transform: (TileData) -> TileData
    ) {
        _tileList.value = _tileList.value.map { tile ->
            if (predicate(tile)) transform(tile) else tile
        }
    }

    private inline fun <reified T : GameState> updateState(
        transform: (T) -> GameState
    ) {
        val current = _uiState.value
        if (current is T) {
            _uiState.value = transform(current)
        }
    }

    /**
     * If tiles are matched, update the state, timer and score.
     * @param imageUrl The image url to check.
     */
    private fun setConditionsWhenMatched(imageUrl: String) {
        if (gameService.isMatched(tileList = _tileList.value, imageUrl = imageUrl)) {
            audioService.playMatchingSound(scope = viewModelScope)
            updateState<GameState.Playing> {
                it.copy(
                    clickCount = 0,
                    score = it.score + gameService.addScore(whereTimerIs = it.timer)
                )
            }
            updateTileList(
                predicate = { it.tileState == TileState.FLIP },
                transform = { it.copy(tileState = TileState.MATCHED) }
            )
            isTileBoardComplete()
        }
    }

    private fun isMaximumClicks(): Boolean {
        val currentState = _uiState.value
        val clickCount = if (currentState is GameState.Playing) currentState.clickCount else 0
        return clickCount == 2
    }

    /**
     * Filter tiles that are flipped and if they are greater than 2, update the tiles.
     * Changed back to this since the application only have small lists.
     */
    private fun checkMaximumOpenTiles(imageUrl: String) {
        if (isMaximumClicks() && !gameService.isMatched(
                imageUrl = imageUrl,
                tileList = _tileList.value
            )
        ) {
            updateState<GameState.Playing> { it.copy(clickCount = 0) }

            viewModelScope.launch {
                audioService.playErrorSound(scope = this)
                delay(200)
                updateTileList(
                    predicate = { it.tileState == TileState.FLIP },
                    transform = { it.copy(tileState = TileState.IDLE) }
                )
            }
        }
    }

    private fun isTileBoardComplete() {
        if (_tileList.value.all { it.tileState == TileState.MATCHED }) {
            updateState<GameState.Playing> { playState ->
                GameState.GameOver(score = playState.score)
            }
        }
    }

}