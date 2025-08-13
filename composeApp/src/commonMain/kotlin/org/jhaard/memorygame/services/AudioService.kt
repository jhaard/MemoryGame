package org.jhaard.memorygame.services

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jhaard.memorygame.sound.AudioManager

class AudioService(private val audioManager: AudioManager) {

    fun playMatchingSound(scope: CoroutineScope) {
        scope.launch {
            audioManager.playSoundEffect(name = "match_edited")
        }
    }

    fun playErrorSound(scope: CoroutineScope) {
        scope.launch {
            audioManager.playSoundEffect(name = "error_edited")
            delay(200)
        }
    }

}