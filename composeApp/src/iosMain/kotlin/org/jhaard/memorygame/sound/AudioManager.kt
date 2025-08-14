package org.jhaard.memorygame.sound

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import platform.AVFAudio.AVAudioPlayer
import platform.Foundation.NSBundle


@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
@OptIn(ExperimentalForeignApi::class)
actual class AudioManager {
    private var backgroundPlayer: AVAudioPlayer? = null
    private val effectPlayers = mutableListOf<AVAudioPlayer>()

    actual suspend fun playBackgroundMusic(loop: Boolean) {
        withContext(Dispatchers.Main) {
            val url = NSBundle.mainBundle
                .URLForResource("start_background", withExtension = "AAC") ?: return@withContext

            backgroundPlayer = AVAudioPlayer(contentsOfURL = url, error = null).apply {
                numberOfLoops = if (loop) -1 else 0
                prepareToPlay()
                play()
            }
        }
    }

    actual suspend fun playSoundEffect(name: String) {

        val url = NSBundle.mainBundle
            .URLForResource(name, withExtension = "wav")

        val player = url?.let {
            AVAudioPlayer(contentsOfURL = it, error = null).apply {
                numberOfLoops = 0
                prepareToPlay()
                play()
            }
        }
        if (player != null) {
            effectPlayers.add(player)
        }

    }

    actual fun pause() {
        backgroundPlayer?.pause()
        effectPlayers.forEach { it.pause() }
    }

    actual fun stop() {
        backgroundPlayer?.stop()
        effectPlayers.forEach { it.stop() }
        effectPlayers.clear()
    }

    actual fun setVolume(volume: Float) {
        backgroundPlayer?.volume = volume
    }

}