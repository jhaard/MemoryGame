package org.jhaard.memorygame.sound

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import platform.AVFAudio.AVAudioPlayer
import platform.Foundation.NSBundle


@OptIn(ExperimentalForeignApi::class)
class IOSAudioManager : AudioManager {
    private var backgroundPlayer: AVAudioPlayer? = null
    private val effectPlayers = mutableListOf<AVAudioPlayer>()


    override suspend fun playBackgroundMusic(loop: Boolean) {
        withContext(Dispatchers.Main) {
            val url = NSBundle.mainBundle
                .URLForResource("background", withExtension = "mp3") ?: return@withContext

            backgroundPlayer = AVAudioPlayer(contentsOfURL = url, error = null).apply {
                numberOfLoops = if (loop) -1 else 0
                prepareToPlay()
                play()
            }
        }
    }

    override suspend fun playSoundEffect(name: String) {
        withContext(Dispatchers.Main) {
            val url = NSBundle.mainBundle
                .URLForResource(name, withExtension = "wav") ?: return@withContext

            val player = AVAudioPlayer(contentsOfURL = url, error = null).apply {
                prepareToPlay()
                play()
            }
            effectPlayers.add(player)
        }
    }

    override fun pause() {
        backgroundPlayer?.pause()
        effectPlayers.forEach { it.pause() }
    }

    override fun stop() {
        backgroundPlayer?.stop()
        effectPlayers.forEach { it.stop() }
        effectPlayers.clear()
    }

    override fun setVolume(volume: Float) {
        backgroundPlayer?.volume = volume
    }
}