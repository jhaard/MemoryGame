package org.jhaard.memorygame.services

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

/**
 * Handles the timer so that current timers cancels when the game is cancelled.
 */
class TimerService {
    private var timerJob: Job? = null


    /**
     * Starting the timer.
     * @param onTick The callback to place in the games state timer.
     * @param onComplete Change game state when timer reaches 0.
     */
    fun startTimer(startTime: Int, scope: CoroutineScope, onTick: (Int) -> Unit, onComplete: () -> Unit) {
        timerJob?.cancel()

        timerJob = scope.launch {
            repeat(startTime) { second ->
                delay(1000)
                if (isActive) onTick(startTime - second - 1)
            }
            if (isActive) onComplete()
        }
    }

    fun stopTimer() {
        timerJob?.cancel()
        timerJob = null
    }
}