package org.jhaard.memorygame.display

import androidx.compose.ui.unit.Dp
import org.jhaard.memorygame.getPlatform
import org.jhaard.memorygame.uiTheme.AppImageSizing

fun getTileSize(screenSize: ScreenSize): Dp {
    val platform = getPlatform()
    var tileSize: Dp = AppImageSizing.defaultTileSize
    if (platform == Platform.ANDROID) {

        tileSize = when {
            screenSize.width in 600..800 && screenSize.height in 1000..1300 &&
                    screenSize.orientation == ScreenOrientation.PORTRAIT -> AppImageSizing.smallTileSize

            screenSize.width in 1200..1300 && screenSize.height in 600..800 &&
                    screenSize.orientation == ScreenOrientation.LANDSCAPE -> AppImageSizing.smallTileSize

            screenSize.width in 1000..1400 && screenSize.height in 2000..2800 &&
                    screenSize.orientation == ScreenOrientation.PORTRAIT -> AppImageSizing.largeTileSize

            screenSize.width in 2000..3000 && screenSize.height in 1000..1400 &&
                    screenSize.orientation == ScreenOrientation.LANDSCAPE -> AppImageSizing.largeTileSize

            else -> AppImageSizing.defaultTileSize
        }

        return tileSize
    }

    if (platform == Platform.IOS) {

        tileSize = when {
            screenSize.width in 300..400 && screenSize.height in 800..900 &&
                    screenSize.orientation == ScreenOrientation.PORTRAIT -> AppImageSizing.largeTileSize

            screenSize.width in 400..500 && screenSize.height in 900..1000 &&
                    screenSize.orientation == ScreenOrientation.PORTRAIT -> AppImageSizing.largeTileSize

            screenSize.width in 800..900 && screenSize.height in 300..400 &&
                    screenSize.orientation == ScreenOrientation.LANDSCAPE -> AppImageSizing.mediumTileSize

            screenSize.width in 900..1000 && screenSize.height in 400..500 &&
                    screenSize.orientation == ScreenOrientation.LANDSCAPE -> AppImageSizing.largeTileSize

            else -> AppImageSizing.defaultTileSize
        }

        return tileSize

    }

    return tileSize

}