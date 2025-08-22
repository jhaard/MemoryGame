package org.jhaard.memorygame


import org.jhaard.memorygame.sound.AudioManager
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton

fun createIosModule() = DI.Module("ios") {
    bind<Orientation>() with singleton { Orientation() }
    bind<AudioManager>() with singleton { AudioManager() }

}