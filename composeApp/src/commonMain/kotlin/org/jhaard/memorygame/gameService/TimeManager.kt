package org.jhaard.memorygame.gameService

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.StateFlow

interface TimeManager {
    // The countdown timer StateFlow variable.
    val timer: StateFlow<Int>

    // The game is running.
    val isRunning: StateFlow<Boolean>

    /**
     * Start the timer.
     * @param seconds Seconds to set timer with.
     * @param scope The scope to use, in this case viewModelScope.
     */
    fun startTimer(seconds: Int, scope: CoroutineScope)

    fun stopGame()

}