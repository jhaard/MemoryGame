package org.jhaard.memorygame.sound

import platform.darwin.NSObject

external class AudioManagerWrapper : NSObject {
    companion object {
        fun playBackgroundMusic(loop: Boolean)
        fun playSoundEffect(name: String)
        fun pause()
        fun stop()
        fun setVolume(volume: Float)
    }
}