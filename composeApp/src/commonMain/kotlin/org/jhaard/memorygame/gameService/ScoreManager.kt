package org.jhaard.memorygame.gameService

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.StateFlow

/**
 * The ScoreSystem implementation for both scoring and timer countdown.
 * // TODO Maybe separate this interface to different implementations.
 */
interface ScoreManager {

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


}