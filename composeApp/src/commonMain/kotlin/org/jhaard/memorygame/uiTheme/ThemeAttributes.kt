package org.jhaard.memorygame.uiTheme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


val BackgroundColor = Color(0xFFfdfdea)
val ForegroundColor = Color(0xFF232323)
val AppBlue = Color(0xFF69b6d9)
val AppGreen = Color(0xFF256f60)
val AppPink = Color(0xFFde92d0)
val AppAqua = Color(0xFF3fd7c5)
val TileFlipBorderColor = AppPink
val TileMatchBorderColor = AppBlue

// Color scheme
val AppColors = lightColorScheme(
    primary = AppBlue,
    secondary = AppPink,
    background = BackgroundColor,
    onPrimary = ForegroundColor,
    tertiary = AppAqua,
    surface = AppGreen,
    onSecondary = TileFlipBorderColor,
    onTertiary = TileMatchBorderColor
)

// Shapes
val AppShapes = Shapes(
    small = RoundedCornerShape(5.dp),
    medium = RoundedCornerShape(10.dp),
    large = RoundedCornerShape(20.dp)
)

// Border width
object AppBorderSizing {
    val small = 2.dp
    val large = 4.dp
    val xlarge = 10.dp
}

// Paddings and spaces
object AppSpacing {
    val xSmall = 5.dp
    val small = 10.dp
    val medium = 20.dp
}

// Elevation
object AppCardElevation {
    val small = 2.dp
}

// Elevation
object AppButtonElevation {
    val pressed = 0.dp
    val unPressed = 8.dp
}

// Image size
object AppImageSizing {
    val smallImageSize = 50.dp
    val largeImageSize = 100.dp
    val largeTileSize = 70.dp
    val mediumTileSize = 60.dp
    val smallTileSize = 55.dp
    val defaultTileSize = 50.dp
}