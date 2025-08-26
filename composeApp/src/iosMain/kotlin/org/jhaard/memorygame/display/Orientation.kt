package org.jhaard.memorygame.display

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.useContents
import platform.UIKit.UIDevice
import platform.UIKit.UIDeviceOrientation
import platform.UIKit.UIScreen

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class Orientation() {

    actual fun getScreenOrientation(): ScreenOrientation {
        val orientation = UIDevice.currentDevice.orientation
        return when (orientation) {
            UIDeviceOrientation.UIDeviceOrientationLandscapeLeft,
            UIDeviceOrientation.UIDeviceOrientationLandscapeRight ->
                ScreenOrientation.LANDSCAPE
            else -> ScreenOrientation.PORTRAIT
        }
    }

    @OptIn(ExperimentalForeignApi::class)
    actual fun getScreenHeight(): Int {
        val bounds = UIScreen.mainScreen.bounds.useContents {
            this.size.height.toInt()
        }
        return bounds
    }

    @OptIn(ExperimentalForeignApi::class)
    actual fun getScreenWidth(): Int {
        val bounds = UIScreen.mainScreen.bounds.useContents {
            this.size.width.toInt()
        }
        return bounds
    }

    actual fun getScreenSize(): ScreenSize {
        return ScreenSize(
            width = getScreenWidth(),
            height = getScreenHeight(),
            orientation = getScreenOrientation()
        )
    }

}