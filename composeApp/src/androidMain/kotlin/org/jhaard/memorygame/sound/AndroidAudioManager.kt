package org.jhaard.memorygame.sound

import android.content.Context
import android.media.MediaPlayer
import android.media.SoundPool
import androidx.collection.arrayMapOf
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jhaard.memorygame.R


class AndroidAudioManager(private val context: Context): AudioManager {
    private val mediaPlayer: MediaPlayer = MediaPlayer.create(context, R.raw.pair)

    private val soundPool = SoundPool.Builder().setMaxStreams(5).build()
    private val soundEffects = arrayMapOf<String, Int>()

    override suspend fun playBackgroundMusic(loop: Boolean) {
        withContext(Dispatchers.Main) {
            mediaPlayer.isLooping = loop
            mediaPlayer.start()
        }
    }

    override suspend fun playSoundEffect(name: String) {
        val soundId = soundEffects.get(key = name)
        soundPool.load(context, soundId!!, 1)
        soundPool.play(soundId, 1f, 1f, 1, 0, 1f)
    }

    override fun pause() {
        mediaPlayer.pause()
    }

    override fun stop() {
        mediaPlayer.stop()
        mediaPlayer.prepare()
    }

    override fun setVolume(volume: Float) {
        mediaPlayer.setVolume(volume, volume)
    }
}