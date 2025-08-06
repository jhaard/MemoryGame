package org.jhaard.memorygame.gameService

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.StateFlow

/**
 * The ScoreSystem implementation for both scoring and timer countdown.
 * // TODO Maybe separate this interface to different implementations.
 */
interface ScoreSystem {

    // The score StateFlow variable.
    val score: StateFlow<Int>

    /**
     * Update the score.
     * @param points The points to update with.
     */
    fun updateScore(points: Int)

    /**
     * Resetting the score.
     */
    fun resetScore()

    // The countdown timer StateFlow variable.
    val timer: StateFlow<Int>

    // isRunning is set to true when game starts.
    val isRunning: StateFlow<Boolean>

    /**
     * Start the timer.
     * @param seconds The time left of the timer.
     * @param scope The scope to use, in this case viewModelScope.
     */
    fun startTimer(seconds: Int, scope: CoroutineScope)

    /**
     * Stop the timer.
     */
    fun stopTimer()

}