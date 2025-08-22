package org.jhaard.memorygame

import android.content.Context
import org.jhaard.memorygame.sound.AudioManager
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton

fun createAndroidModule(context: Context) = DI.Module("android") {
    bind<Context>() with singleton { context }
    bind<Orientation>() with singleton { Orientation(instance()) }
    bind<AudioManager>() with singleton { AudioManager(instance()) }

}