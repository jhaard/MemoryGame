package org.jhaard.memorygame.sound

import android.content.Context
import android.media.MediaPlayer
import android.media.SoundPool
import androidx.collection.arrayMapOf
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jhaard.memorygame.R


@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class AudioManager(private val context: Context) {
    private val mediaPlayer: MediaPlayer = MediaPlayer.create(context, R.raw.pair)

    private val soundPool = SoundPool.Builder().setMaxStreams(5).build()
    private val soundEffects = arrayMapOf<String, Int>()

    init {
        soundEffects.put("pair", R.raw.pair)
    }

    actual suspend fun playBackgroundMusic(loop: Boolean) {
        withContext(Dispatchers.Main) {
            mediaPlayer.isLooping = loop
            mediaPlayer.start()
        }
    }

    actual suspend fun playSoundEffect(name: String) {
        val resourceId = soundEffects[name]
        if (resourceId != null) {
            val soundId = soundPool.load(context, resourceId, 1)

            soundPool.setOnLoadCompleteListener { _, sampleId, status ->
                if (status == 0 && sampleId == soundId) {
                    soundPool.play(soundId, 1f, 1f, 1, 0, 1f)
                    soundPool.setOnLoadCompleteListener(null)
                }
            }
        }
    }

    actual fun pause() {
        mediaPlayer.pause()
    }

    actual fun stop() {
        mediaPlayer.stop()
        mediaPlayer.prepare()
    }

    actual fun setVolume(volume: Float) {
        mediaPlayer.setVolume(volume, volume)
    }
}