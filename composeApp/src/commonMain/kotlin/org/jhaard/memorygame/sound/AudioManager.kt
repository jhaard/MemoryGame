package org.jhaard.memorygame.sound


@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect class AudioManager {
    suspend fun playBackgroundMusic(loop: Boolean = true)
    suspend fun playSoundEffect(name: String)
    fun pause()
    fun stop()
    fun setVolume(volume: Float)
}