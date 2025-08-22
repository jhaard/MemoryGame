package org.jhaard.memorygame

import android.content.Context
import android.content.res.Configuration

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class Orientation(private val context: Context) {

    actual fun getScreenOrientation(): ScreenOrientation {
        return when (context.resources.configuration.orientation) {
            Configuration.ORIENTATION_LANDSCAPE -> ScreenOrientation.LANDSCAPE
            else -> ScreenOrientation.PORTRAIT
        }
    }

    actual fun getScreenHeight(): Int {
        val displayMetrics = context.resources.displayMetrics
        return displayMetrics.heightPixels
    }

    actual fun getScreenWidth(): Int {
        val displayMetrics = context.resources.displayMetrics
        return displayMetrics.widthPixels
    }

    actual fun getScreenSize(): ScreenSize {
        return ScreenSize(
            width = getScreenWidth(),
            height = getScreenHeight(),
            orientation = getScreenOrientation()
        )
    }

}
