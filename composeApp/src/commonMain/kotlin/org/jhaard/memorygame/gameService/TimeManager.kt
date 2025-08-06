package org.jhaard.memorygame.gameService

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.StateFlow

interface TimeManager {
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
     * Update timer.
     * @param seconds The amount of seconds to add.
     */
    fun updateTimer(seconds: Int)

    /**
     * Stop the timer.
     */
    fun stopTimer()

}