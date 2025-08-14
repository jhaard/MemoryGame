package org.jhaard.memorygame.services

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.jhaard.memorygame.sound.AudioManager

/**
 * Service class layer for playing and stopping audio.
 * @param audioManager The AudioManager to call.
 */
class AudioService(private val audioManager: AudioManager) {

    // Background music.
    fun playBackgroundMusic(scope: CoroutineScope) {
        scope.launch {
            audioManager.setVolume(0.4f)
            audioManager.playBackgroundMusic(loop = true)
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

    fun stopBackgroundMusic() {
        audioManager.stop()
    }

}