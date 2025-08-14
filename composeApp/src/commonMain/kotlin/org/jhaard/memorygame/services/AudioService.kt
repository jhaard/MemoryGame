package org.jhaard.memorygame.services

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.jhaard.memorygame.sound.AudioManager

/**
 * Service class layer for playing and stopping audio.
 * @param audioManager The AudioManager to call.
 */
class AudioService(private val audioManager: AudioManager) {

    // Start background music.
    fun playBackgroundMusic(scope: CoroutineScope) {
        scope.launch {
            audioManager.setVolume(0.1f)
            audioManager.playBackgroundMusic(loop = true)
        }
    }

    // Stop background music.
    fun stopBackgroundMusic(scope: CoroutineScope) {
        scope.launch {
            audioManager.stop()
        }
    }

    // Stop background music.
    fun pauseBackgroundMusic(scope: CoroutineScope) {
        scope.launch {
            audioManager.pause()
        }
    }

    // Sound effect - Match.
    fun playMatchingSound(scope: CoroutineScope) {
        scope.launch {
            audioManager.playSoundEffect(name = "match_edited")
        }
    }

    // Sound effect - Error matching tiles.
    fun playErrorSound(scope: CoroutineScope) {
        scope.launch {
            audioManager.playSoundEffect(name = "error_edited")
        }
    }

}