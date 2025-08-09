package org.jhaard.memorygame.sound



interface AudioManager {
    suspend fun playBackgroundMusic(loop: Boolean = true)
    suspend fun playSoundEffect(name: String)
    fun pause()
    fun stop()
    fun setVolume(volume: Float)
}