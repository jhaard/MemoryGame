package org.jhaard.memorygame.sound


@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class AudioManager {

    actual suspend fun playBackgroundMusic(loop: Boolean) {
        AudioManagerWrapper.playBackgroundMusic(loop = loop)
    }

    actual suspend fun playSoundEffect(name: String) {
        AudioManagerWrapper.playSoundEffect(name = name)
    }

    actual fun pause() {
        AudioManagerWrapper.pause()
    }

    actual fun stop() {
        AudioManagerWrapper.stop()
    }

    actual fun setVolume(volume: Float) {
        AudioManagerWrapper.setVolume(volume = volume)
    }

}