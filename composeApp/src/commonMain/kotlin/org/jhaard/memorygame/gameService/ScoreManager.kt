package org.jhaard.memorygame.gameService

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.StateFlow

/**
 * The ScoreSystem implementation for both scoring and timer countdown.
 * // TODO Maybe separate this interface to different implementations.
 */
interface ScoreManager {

    val score: StateFlow<Int>

    fun updateScore(): Int

    fun resetScore()


}